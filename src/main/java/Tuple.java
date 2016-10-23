package main.java;

import main.java.dfa.DFA;

import java.util.HashMap;
import java.util.List;

public class Tuple {
    private final List<String> alphabets;
    private final HashMap<String, HashMap<String, String>> delta;
    private final String start_state;
    private final List<String> final_states;
    private List<String> states;

    public Tuple(List<String> states, List<String> alphabets, HashMap<String, HashMap<String, String>> delta, String start_state, List<String> final_states) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.start_state = start_state;
        this.final_states = final_states;
    }

    public DFA getDFA(DFAGenerator runner) {
        return runner.create(states, alphabets, delta, start_state, final_states);
    }
}
