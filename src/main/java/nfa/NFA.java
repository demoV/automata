package main.java.nfa;

import main.java.FA;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NFA implements FA {
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
            String alphabet = String.valueOf(string.charAt(i));
            List<String> epsilons = transitions.epsilonStates(currentState);
            if (epsilons != null)
                addAcceptanceFor(epsilons, string.substring(i));
            List<String> currentStates = transitions.nextStates(currentState, alphabet);
            if (currentStates == null || currentStates.size() == 0) {
                currentState = null;
                break;
            }

            currentState = currentStates.remove(currentStates.size() - 1);
            addAcceptanceFor(currentStates, string.substring(i + 1));
        }
        if (currentState != null) {
            List<String> strings = transitions.epsilonStates(currentState);
            if (strings != null) for (String s : strings) {
                acceptedList.add(finalState.contains(s));
            }
        }
        acceptedList.add(finalState.contains(currentState));
        return acceptedList.contains(true);
    }

    private void addAcceptanceFor(List<String> states, String substring) {
        for (String state : states) {
            acceptedList.add(new NFA(transitions, state, finalState).isAccepted(substring));
        }
    }

}
