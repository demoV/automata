package org.step.lalit.dfa;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void dfaCanGiveThatGivenStringIsPassingOrNot() throws Exception {
        Set<String> alphabets = new HashSet<>(2);
        alphabets.add("0");
        alphabets.add("1");

        Set<String> states = new HashSet<>(2);
        states.add("q1");
        states.add("q2");

        String initialState = "q1";

        Set<String> finalState = new HashSet<>(1);
        finalState.add("q2");

        Transitions transitionsFunction = new Transitions();
        transitionsFunction.add("q1", "0", "q1");
        transitionsFunction.add("q1", "1", "q2");
        transitionsFunction.add("q2", "0", "q1");
        transitionsFunction.add("q2", "1", "q2");

        DFA dfa = new DFA(states, alphabets, initialState, finalState, transitionsFunction);
        Boolean isPassing = dfa.isAccepted("01001");
        assertTrue(isPassing);
        assertFalse(dfa.isAccepted("00110"));
        assertTrue(dfa.isAccepted("1111111"));
    }
}