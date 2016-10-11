package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DFA {

    private final Set<String> states;
    private final Set<String> alphabets;
    private final Set<String> initialState;
    private final Set<String> finalState;
    private final Map<String, HashMap<String, String>> transition;

    public DFA(Set<String> states, Set<String> alphabets, Set<String> initialState, Set<String> finalState, Map<String, HashMap<String, String>> transition) {
        this.states = states;
        this.alphabets = alphabets;
        this.initialState = initialState;
        this.finalState = finalState;
        this.transition = transition;
    }

    public Boolean isPassing(String string) {
        String currentState = new ArrayList<>(initialState).get(0);
        for (int i = 0; i < string.length(); i++){
            char oneChar = string.charAt(i);
            currentState = transition.get(currentState).get(String.valueOf(oneChar));
        }
        return finalState.contains(currentState);
    }
}
