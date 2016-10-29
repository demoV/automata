package main.java;

import main.java.dfa.DFA;

import java.util.HashMap;
import java.util.List;

public interface DFACreator {
    DFA create(List<String> states, List<String> alphabets, HashMap<String, HashMap<String, String>> delta, String startState, List<String> finalStates);
}
