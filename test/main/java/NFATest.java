package main.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class NFATest {
    @Test
    public void shouldBeAbleToRunTransition() throws Exception {
        String initialState = "q1";

        Set<String> finalState = new HashSet<>(1);
        finalState.add("q2");

        NFATransitions transitions = new NFATransitions();
        ArrayList<String> q1InputOne = new ArrayList<>();
        q1InputOne.add("q2");

        ArrayList<String> q1InputEpsilon = new ArrayList<>();
        q1InputEpsilon.add("q2");

        transitions.add("q1", "1", q1InputOne);
        transitions.add("q1", "E", q1InputEpsilon);

        ArrayList<String> q2InputZero = new ArrayList<>();
        q2InputZero.add("q1");

        ArrayList<String> q2InputOne = new ArrayList<>();
        q2InputOne.add("q2");

        transitions.add("q2", "0", q2InputZero);
        transitions.add("q2", "1", q2InputOne);

        NFA nfa = new NFA(transitions, initialState, finalState);
        Boolean isPassing = nfa.isAccepted("01");
        assertTrue(isPassing);
    }
}