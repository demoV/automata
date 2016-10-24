package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NFATransitions {
    private HashMap<String, HashMap<String, List<String>>> transitions = new HashMap<>();

    public void add(String state, String alphabet, ArrayList<String> nextStates) {
        if (!transitions.containsKey(state))
            transitions.put(state, new HashMap<String, List<String>>());
        transitions.get(state).put(alphabet, nextStates);
    }

    public List<String> epsilonStates(String currentState) {
        return transitions.get(currentState).get("E");
    }

    public List<String> nextStates(String currentState, String alphabet) {
        return transitions.get(currentState).get(alphabet);
    }
}
