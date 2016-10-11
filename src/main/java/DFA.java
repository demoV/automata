package main.java;

import java.util.Set;

public class DFA {

    private final Set<String> states;
    private final Set<String> alphabets;
    private final String initialState;
    private final Set<String> finalState;
    private final Transition transition;

    public DFA(Set<String> states, Set<String> alphabets, String initialState, Set<String> finalState, Transition transition) {
        this.states = states;
        this.alphabets = alphabets;
        this.initialState = initialState;
        this.finalState = finalState;
        this.transition = transition;
    }

    public Boolean isPassing(String string) {
        String currentState = initialState;
        for (int i = 0; i < string.length(); i++) {
            String oneChar = String.valueOf(string.charAt(i));
            currentState = transition.nextState(currentState, oneChar);
        }
        return finalState.contains(currentState);
    }
}
