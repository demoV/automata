package main.java.dfa;

import java.util.HashMap;

public class Transitions {
    private HashMap<String, HashMap> transitions = new HashMap<>();

    public void add(String currentState, String alphabet, String nextState) {
        if (!transitions.containsKey(currentState))
            transitions.put(currentState, new HashMap<String, String>());
        transitions.get(currentState).put(alphabet, nextState);
    }

    public String nextState(String currentState, String alphabet) {
        return transitions.get(currentState).get(alphabet).toString();
    }

    public void addAll(HashMap<String, HashMap> delta) {
        transitions = delta;
    }
}
