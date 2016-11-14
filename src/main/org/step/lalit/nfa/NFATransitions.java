package org.step.lalit.nfa;

import org.step.lalit.States;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NFATransitions {
    private final String EPSILON = "e";
    private HashMap<String, HashMap> transitions = new HashMap<>();

    public void add(String state, String alphabet, ArrayList<String> nextStates) {
        if (!transitions.containsKey(state))
            transitions.put(state, new HashMap<String, List<String>>());
        transitions.get(state).put(alphabet, nextStates);
    }

    public States epsilonStates(String currentState) {
        HashMap epsilonMap = new HashMap();
        if (transitions.containsKey(currentState))
            epsilonMap = transitions.get(currentState);
        States eps = new States();
        ArrayList<String> arrayList = (ArrayList<String>) epsilonMap.get(EPSILON);
        if (arrayList != null) {
            eps.addAll(arrayList);
        }
        return eps;
    }

    States allEpsilonStates(String currentState) {
        States epsilons = epsilonStates(currentState);
        States currentEpsilons = new States();
        currentEpsilons.add(currentState);
        return allEpsilonStates(epsilons, currentEpsilons);
    }

    private States allEpsilonStates(States epsilons, States currentEpsilons) {
        for (String epsilon : epsilons) {
            States thisEpsilons;
            if (!currentEpsilons.contains(epsilon)) {
                currentEpsilons.add(epsilon);
                thisEpsilons = epsilonStates(epsilon);
                allEpsilonStates(thisEpsilons, currentEpsilons);
            }
        }
        return currentEpsilons;
    }

    private States nextStates(String currentState, String alphabet) {
        HashMap hashMap = transitions.get(currentState);
        States states = new States();
        if (hashMap != null) {
            ArrayList<String> strings = (ArrayList<String>) hashMap.get(alphabet);
            if (strings != null)
                states.addAll(strings);
        }
        return states;
    }

    public void addAll(HashMap<String, HashMap> delta) {
        transitions = delta;
    }


    States nextStates(States currentStates, String alphabet) {
        States next = new States();
        for (String currentState : currentStates) {
            States states = nextStates(currentState, alphabet);
            next.addAll(states);
            for (String state : states) {
                next.addAll(allEpsilonStates(state));
            }
        }
        return next;
    }
}
