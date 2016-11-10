package org.step.lalit.nfa;

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
        HashMap epsilonMap = new HashMap();
        if (transitions.containsKey(currentState))
            epsilonMap = transitions.get(currentState);
        List<String> epsilons = (List<String>) epsilonMap.get("e");
        if (epsilons != null)
            return epsilons;
        return new ArrayList<>();
    }

    public ArrayList<String> allEpsilons(String currentState) {
        List<String> epsilons = epsilonStates(currentState);
        ArrayList<String> currentEpsilons = new ArrayList<>();
        currentEpsilons.add(currentState);
        return allEpsilons(epsilons, currentEpsilons);
    }

    private ArrayList<String> allEpsilons(List<String> epsilons, ArrayList<String> currentEpsilons) {
        for (String epsilon : epsilons) {
            List<String> thisEpsilons;
            if (!currentEpsilons.contains(epsilon)) {
                currentEpsilons.add(epsilon);
                thisEpsilons = epsilonStates(epsilon);
                if (thisEpsilons != null) {
                    return allEpsilons(thisEpsilons, currentEpsilons);
                }
            }
        }
        return currentEpsilons;
    }

    public List<String> nextStates(String currentState, String alphabet) {
        HashMap hashMap = transitions.get(currentState);
        if (hashMap != null) {
            ArrayList<String> strings = (ArrayList<String>) hashMap.get(alphabet);
            if (strings != null)
                return (List<String>) strings.clone();
        }
        return new ArrayList<>();

    }

    public void addAll(HashMap<String, HashMap> delta) {
        transitions = delta;
    }


    public List<String> nextStates(List<String> currentStates, String alphabet) {
        ArrayList<String> nextStates = new ArrayList<>();
        for (String currentState : currentStates) {
            nextStates.addAll(nextStates(currentState, alphabet));
            nextStates.addAll(allEpsilons(currentState));
        }
        return nextStates;
    }
}
