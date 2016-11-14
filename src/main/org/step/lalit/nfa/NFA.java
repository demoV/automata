package org.step.lalit.nfa;

import org.step.lalit.States;
import org.step.lalit.automata.FA;

public class NFA implements FA {
    private final NFATransitions transitions;
    private final String initialState;
    private final States finalState;

    public NFA(NFATransitions transitions, String initialState, States finalState) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public Boolean isAccepted(String string) {
        String currentState = initialState;
        States currentStates = transitions.allEpsilonStates(currentState);
        for (int i = 0; i < string.length(); i++) {
            String alphabet = String.valueOf(string.charAt(i));
            currentStates = transitions.nextStates(currentStates, alphabet);
        }
        return currentStates.containsAny(finalState);
    }
}
