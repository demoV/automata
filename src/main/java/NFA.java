package main.java;

import main.java.dfa.Transitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NFA {
    private final Transitions transitions;
    private final String initialState;
    private final Set<String> finalState;
    private List<Boolean> acceptedList;

    public NFA(Transitions transitions, String initialState, Set<String> finalState) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public Boolean isAccepted(String string) {
        String currentState = initialState;
        acceptedList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            String abs = transitions.abs(currentState);
            if (abs != null)
                acceptedList.add(new NFA(transitions, abs, finalState).isAccepted(string.substring(i)));
            char oneChar = string.charAt(i);
            currentState = transitions.nextState(currentState, String.valueOf(oneChar));
            if (currentState == null)
                break;
        }
        acceptedList.add(finalState.contains(currentState));
        return acceptedList.contains(true);
    }
}
