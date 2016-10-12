package main.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DFATest {
    @Test
    public void shouldTake5Tuple() throws Exception {
        Set<String> alphabets = new HashSet<>(2);
        alphabets.add("0");
        alphabets.add("1");

        Set<String> states = new HashSet<>(2);
        states.add("q1");
        states.add("q2");

        String initialState = "q1";

        Set<String> finalState = new HashSet<>(1);
        finalState.add("q2");

        Transition transitionFunction = new Transition();
        transitionFunction.add("q1", "0", "q1");
        transitionFunction.add("q1", "1", "q2");
        transitionFunction.add("q2", "0", "q1");
        transitionFunction.add("q2", "1", "q2");

        DFA dfa = new DFA(states, alphabets, initialState, finalState, transitionFunction);
        Boolean isPassing = dfa.isPassing("01001");
        assertEquals(true, isPassing);
        assertEquals(false, dfa.isPassing("00110"));
        assertEquals(true, dfa.isPassing("1111111"));
    }
}