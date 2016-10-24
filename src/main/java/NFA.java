package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NFA {
    private final NFATransitions transitions;
    private final String initialState;
    private final Set<String> finalState;
    private List<Boolean> acceptedList;

    public NFA(NFATransitions transitions, String initialState, Set<String> finalState) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public Boolean isAccepted(String string) {
        String currentState = initialState;
        acceptedList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            List<String> epsilons = transitions.epsilonStates(currentState);
            if (epsilons != null) for (String epsilonState : epsilons)
                acceptedList.add(new NFA(transitions, epsilonState, finalState).isAccepted(string.substring(i)));
            List<String> currentStates = transitions.nextStates(currentState, String.valueOf(string.charAt(i)));
            if (currentStates == null) break;
            currentState = currentStates.get(currentStates.size() - 1);
            for (int j = 0; j < currentStates.size() - 1; j++)
                acceptedList.add(new NFA(transitions, currentStates.get(j), finalState).isAccepted(string.substring(i)));
        }
        acceptedList.add(finalState.contains(currentState));
        return acceptedList.contains(true);
    }

}
