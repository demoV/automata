package main.java;

import main.java.dfa.DFA;

import java.util.HashMap;
import java.util.List;

public class Tuple {
    private final List<String> alphabets;
    private final HashMap<String, HashMap<String, String>> delta;
    private final String startState;
    private final List<String> finalStates;
    private List<String> states;

    public Tuple(List<String> states, List<String> alphabets, HashMap<String, HashMap<String, String>> delta, String startState, List<String> finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public DFA getDFA(DFAGenerator runner) {
        return runner.create(states, alphabets, delta, startState, finalStates);
    }
}
