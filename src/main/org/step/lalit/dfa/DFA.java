package org.step.lalit.dfa;

import org.step.lalit.FA;

import java.util.Set;

public class DFA implements FA {

    private final Set<String> states;
    private final Set<String> alphabets;
    private final String initialState;
    private final Set<String> finalState;
    private final Transitions transitions;

    public DFA(Set<String> states, Set<String> alphabets, String initialState, Set<String> finalState, Transitions transitions) {
        this.states = states;
        this.alphabets = alphabets;
        this.initialState = initialState;
        this.finalState = finalState;
        this.transitions = transitions;
    }

    public Boolean isAccepted(String string) {
        String currentState = initialState;
        for (int i = 0; i < string.length(); i++) {
            String oneChar = String.valueOf(string.charAt(i));
            currentState = transitions.nextState(currentState, oneChar);
        }
        return finalState.contains(currentState);
    }
}
