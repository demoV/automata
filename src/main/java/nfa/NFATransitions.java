package main.java.nfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NFATransitions {
    private HashMap<String, HashMap> transitions = new HashMap<>();

    public void add(String state, String alphabet, ArrayList<String> nextStates) {
        if (!transitions.containsKey(state))
            transitions.put(state, new HashMap<String, List<String>>());
        transitions.get(state).put(alphabet, nextStates);
    }

    public List<String> epsilonStates(String currentState) {

        List<String> epsilons = (List<String>) transitions.get(currentState).get("e");
        return epsilons;
    }

    public List<String> nextStates(String currentState, String alphabet) {
        ArrayList<String> strings = (ArrayList<String>) transitions.get(currentState).get(alphabet);
        if (strings != null)
            return (List<String>) strings.clone();
        return null;
    }

    public void addAll(HashMap<String, HashMap> delta) {
        transitions = delta;
    }
}
