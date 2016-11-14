package org.step.lalit.automata;

import org.step.lalit.States;
import org.step.lalit.nfa.NFA;
import org.step.lalit.nfa.NFATransitions;

import java.util.HashMap;
import java.util.List;

public class DFAManager {
    private final String name;
    private final String type;
    private final Tuple tuple;
    private final List<String> pass_cases;
    private final List<String> fail_cases;

    public DFAManager(String name, String type, Tuple tuple, List<String> pass_cases, List<String> fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    private FACreator nfaCreator() {
        return new FACreator() {
            @Override
            public FA create(List<String> states, List<String> alphabets, HashMap<String, HashMap> delta, String startState, List<String> finalStates) {
                States finalSet = new States();
                finalSet.addAll(finalStates);
                NFATransitions nfaTransitions = new NFATransitions();
                nfaTransitions.addAll(delta);
                return new NFA(nfaTransitions, startState, finalSet);
            }
        };
    }

    public DFARunner createRunner(FACreator creator) {

        if (type.equals("dfa")) {
            return new DFARunner(name, tuple.buildFA(creator), pass_cases, fail_cases, type);
        } else if (type.equals("nfa")) {
            return new DFARunner(name, tuple.buildFA(nfaCreator()), pass_cases, fail_cases, type);
        }
        return null;
    }
}
