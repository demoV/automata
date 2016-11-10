package org.step.lalit;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.step.lalit.nfa.NFA;
import org.step.lalit.nfa.NFATransitions;

import java.util.ArrayList;
import java.util.HashMap;
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

        Assert.assertTrue(nfa.isAccepted(""));
        Assert.assertTrue(nfa.isAccepted("0"));
        Assert.assertTrue(nfa.isAccepted("1"));
        Assert.assertTrue(nfa.isAccepted("00"));
        Assert.assertTrue(nfa.isAccepted("001"));
        Assert.assertTrue(nfa.isAccepted("0011"));
        Assert.assertTrue(nfa.isAccepted("0001"));
        Assert.assertTrue(nfa.isAccepted("011"));
        Assert.assertTrue(nfa.isAccepted("000111"));

        Assert.assertFalse(nfa.isAccepted("10"));
        Assert.assertFalse(nfa.isAccepted("1110"));
        Assert.assertFalse(nfa.isAccepted("010"));
        Assert.assertFalse(nfa.isAccepted("10101"));
        Assert.assertFalse(nfa.isAccepted("1101"));
    }

    @Test
    public void run1_0_or_0_1() throws Exception {
        NFATransitions transitions = new NFATransitions();

        ArrayList<String> q1Epsilon = new ArrayList<>();
        q1Epsilon.add("q2");
        q1Epsilon.add("q4");
        transitions.add("q1", "e", q1Epsilon);

        ArrayList<String> q2Epsilon = new ArrayList<>();
        q2Epsilon.add("q3");
        transitions.add("q2", "e", q2Epsilon);

        ArrayList<String> q2ZeroInput = new ArrayList<>();
        q2ZeroInput.add("q2");
        transitions.add("q2", "0", q2ZeroInput);

        ArrayList<String> q3Epsilon = new ArrayList<>();
        q3Epsilon.add("q6");
        transitions.add("q3", "e", q3Epsilon);

        ArrayList<String> q3OneInput = new ArrayList<>();
        q3OneInput.add("q3");
        transitions.add("q3", "1", q3OneInput);

        ArrayList<String> q4Epsilon = new ArrayList<>();
        q4Epsilon.add("q5");
        transitions.add("q4", "e", q4Epsilon);

        ArrayList<String> q4OneInput = new ArrayList<>();
        q4OneInput.add("q4");
        transitions.add("q4", "1", q4OneInput);

        ArrayList<String> q5Epsilon = new ArrayList<>();
        q5Epsilon.add("q7");
        transitions.add("q5", "e", q5Epsilon);

        ArrayList<String> q5ZeroInput = new ArrayList<>();
        q5ZeroInput.add("q5");
        transitions.add("q5", "0", q5ZeroInput);

        HashSet<String> finalStates = new HashSet<>();
        finalStates.add("q6");
        finalStates.add("q7");

        String startState = "q1";

        NFA nfa = new NFA(transitions, startState, finalStates);
        Assert.assertTrue(nfa.isAccepted(""));
    }

    @Test
    public void shouldRunUnionOfZeroAndOne() throws Exception {
        String a = "{'delta' : {'q1':{'e':['q2','q4']},'q3':{'0':['q3']},'q9':{'e':['q7']},'q7':{'1':['q8'],'e':['q9']},'q2':{'0':['q3']},'q8':{'0':['q9']},'q5':{'1':['q6']},'q6':{'e':['q7','q4']},'q4':{'0':['q5'],'e':['q6']}}}";
        MyDelta myDelta = new Gson().fromJson(a, MyDelta.class);
        HashMap<String, HashMap> delta = myDelta.getDelta();

        NFATransitions nfaTransitions = new NFATransitions();
        nfaTransitions.addAll(delta);

        String startState = "q1";
        HashSet<String> finalStates = new HashSet<>();
        finalStates.add("q3");
        finalStates.add("q9");
        finalStates.add("q6");
//        pass_cases":["0","000","01","10","0110"],"fail_cases":["1","11","111","1101","0111"]
        NFA nfa = new NFA(nfaTransitions, startState, finalStates);
//        Assert.assertTrue(nfa.isAccepted("0"));
//        Assert.assertTrue(nfa.isAccepted("000"));
//        Assert.assertTrue(nfa.isAccepted("01"));
//        Assert.assertTrue(nfa.isAccepted("10"));
//        Assert.assertTrue(nfa.isAccepted("0110"));
//
//        Assert.assertFalse(nfa.isAccepted("1"));
//        Assert.assertFalse(nfa.isAccepted("11"));
//        Assert.assertFalse(nfa.isAccepted("111"));
        Assert.assertFalse(nfa.isAccepted("11101"));
//        Assert.assertFalse(nfa.isAccepted("0111"));
    }

    @Test
    public void canHandleByDirectionalEpsilon() throws Exception {
        NFATransitions transitions = new NFATransitions();
        ArrayList<String> q1Epsilon = new ArrayList<>();
        q1Epsilon.add("q2");
        transitions.add("q1", "e", q1Epsilon);

        ArrayList<String> q1ZeroInput = new ArrayList<>();
        q1ZeroInput.add("q2");
        transitions.add("q1", "0", q1ZeroInput);

        ArrayList<String> q2Epsilon = new ArrayList<>();
        q2Epsilon.add("q1");
        transitions.add("q2", "e", q2Epsilon);
        ArrayList<String> q2ZeroInput = new ArrayList<>();
        q2ZeroInput.add("q2");
        transitions.add("q2", "0", q2ZeroInput);

        HashSet<String> finalStates = new HashSet<>();
        finalStates.add("q2");
        NFA nfa = new NFA(transitions, "q1", finalStates);
        Assert.assertTrue(nfa.isAccepted("00"));
    }
}