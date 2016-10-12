package main.java;

import java.util.HashMap;
import java.util.Map;

public class Transition {
    private Map<String, Map<String, String>> transitions = new HashMap<>();


    public void add(String currentState, String alphabet, String nextState) {
        if (!transitions.containsKey(currentState))
            transitions.put(currentState, new HashMap<String, String>());
        transitions.get(currentState).put(alphabet, nextState);
    }

    public String nextState(String currentState, String alphabet) {
        return transitions.get(currentState).get(alphabet);
    }
}
