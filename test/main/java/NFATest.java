package main.java;

import main.java.dfa.Transitions;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class NFATest {
    @Test
    public void shouldBeAbleToRunTransition() throws Exception {
        String initialState = "q1";

        Set<String> finalState = new HashSet<>(1);
        finalState.add("q2");

        Transitions transitionsFunction = new Transitions();
        transitionsFunction.add("q1", "1", "q2");
        transitionsFunction.add("q1", "E", "q2");

        transitionsFunction.add("q2", "0", "q1");
        transitionsFunction.add("q2", "1", "q2");

        NFA nfa = new NFA(transitionsFunction, initialState, finalState);
        Boolean isPassing = nfa.isAccepted("01");
        assertTrue(isPassing);
    }
}