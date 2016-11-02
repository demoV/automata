package main.java;

import main.java.nfa.NFA;
import main.java.nfa.NFATransitions;
import org.junit.Assert;
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
        transitions.add("q1", "e", q1InputEpsilon);

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

    @Test
    public void name() throws Exception {
        NFATransitions transitions = new NFATransitions();

        ArrayList<String> q1InputEpsilon = new ArrayList<>();
        q1InputEpsilon.add("q2");
        q1InputEpsilon.add("q5");

        transitions.add("q1", "e", q1InputEpsilon);

        ArrayList<String> q2InputZero = new ArrayList<>();
        q2InputZero.add("q3");
        transitions.add("q2", "0", q2InputZero);

        ArrayList<String> q3InputOne = new ArrayList<>();
        q3InputOne.add("q4");
        transitions.add("q3", "1", q3InputOne);

        ArrayList<String> q4InputZero = new ArrayList<>();
        q4InputZero.add("q3");
        transitions.add("q4", "0", q4InputZero);

        ArrayList<String> q5InputOne = new ArrayList<>();
        q5InputOne.add("q6");
        transitions.add("q5", "1", q5InputOne);

        ArrayList<String> q6InputZero = new ArrayList<>();
        q6InputZero.add("q7");
        transitions.add("q6", "0", q6InputZero);

        ArrayList<String> q7InputOne = new ArrayList<>();
        q7InputOne.add("q6");
        transitions.add("q7", "1", q7InputOne);

        HashSet<String> finalSet = new HashSet<>();
        finalSet.add("q3");
        finalSet.add("q6");
        NFA nfa = new NFA(transitions, "q1", finalSet);
        Assert.assertTrue(nfa.isAccepted("010"));
        Assert.assertTrue(nfa.isAccepted("0"));
        Assert.assertTrue(nfa.isAccepted("01010"));
        Assert.assertTrue(nfa.isAccepted("1"));
        Assert.assertTrue(nfa.isAccepted("101"));
        Assert.assertTrue(nfa.isAccepted("10101"));

        Assert.assertFalse(nfa.isAccepted(""));
        Assert.assertFalse(nfa.isAccepted("10"));
        Assert.assertFalse(nfa.isAccepted("01"));
        Assert.assertFalse(nfa.isAccepted("11"));
        Assert.assertFalse(nfa.isAccepted("00"));
        Assert.assertFalse(nfa.isAccepted("100"));
        Assert.assertFalse(nfa.isAccepted("1100"));
    }

    @Test
    public void shouldPassForOddNumberOfZero() throws Exception {
//        "delta":{"q1":{"e":["q2"],"0":["q1"]},"q2":{"1":["q2"]}}
        NFATransitions transitions = new NFATransitions();

        ArrayList<String> q1InputEpsilon = new ArrayList<>();
        q1InputEpsilon.add("q2");

        transitions.add("q1", "e", q1InputEpsilon);

        ArrayList<String> q1InputZero = new ArrayList<>();
        q1InputZero.add("q1");
        transitions.add("q1", "0", q1InputZero);


        ArrayList<String> q2InputOne = new ArrayList<>();
        q2InputOne.add("q2");
        transitions.add("q2", "1", q2InputOne);

        String startState = "q1";
        HashSet<String> finalStates = new HashSet<>();
        finalStates.add("q2");

        NFA nfa = new NFA(transitions, startState, finalStates);
//        "pass_cases":["","0","1","00","001","0011","0001","011","000111"],"fail_cases":["10","1110","010","10101","1101"]
//        Assert.assertTrue(nfa.isAccepted(""));


        Assert.assertTrue(nfa.isAccepted("0"));
    }
}