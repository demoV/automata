package org.step.lalit.nfa;

import org.step.lalit.FA;

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
        List<String> currentStates = transitions.allEpsilons(currentState);
        for (int i = 0; i < string.length(); i++) {
            String alphabet = String.valueOf(string.charAt(i));
            currentStates = transitions.nextStates(currentStates, alphabet);
        }
        return isAnyFinalState(currentStates);
    }

    private Boolean isAnyFinalState(List<String> currentStates) {
        for (String state : finalState) {
            if (currentStates.contains(state))
                return true;
        }
        return false;
    }
}
