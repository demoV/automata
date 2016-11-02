package main.java;

import java.util.HashMap;
import java.util.List;

public interface FACreator {
    FA create(List<String> states, List<String> alphabets, HashMap<String, HashMap> delta, String startState, List<String> finalStates);
}
