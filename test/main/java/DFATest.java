package main.java;

import main.java.DFA;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFATest {
    @Test
    public void shouldTake5Tuple() throws Exception {
        Set<String> alphabets = new HashSet<>(2);
        alphabets.add("0");
        alphabets.add("1");

        Set<String> states = new HashSet<>(2);
        states.add("q1");
        states.add("q2");

        Set<String> initialState = new HashSet<>(1);
        initialState.add("q1");

        Set<String> finalState = new HashSet<>(1);
        finalState.add("q2");

        Map<String, HashMap<String, String>> transition = new HashMap<>();
        transition.put("q1", new HashMap<String, String>());
        transition.get("q1").put("0", "q1");
        transition.get("q1").put("1", "q2");

        transition.put("q2", new HashMap<String, String>());
        transition.get("q2").put("0", "q1");
        transition.get("q2").put("1", "q2");



        DFA dfa = new DFA(states, alphabets, initialState, finalState, transition);
        Boolean isPassing = dfa.isPassing("01001");
        Assert.assertEquals(true, isPassing);
        Assert.assertEquals(false, dfa.isPassing("00110"));


    }
}