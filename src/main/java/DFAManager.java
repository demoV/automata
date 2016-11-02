package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import main.java.dfa.DFA;
import main.java.nfa.NFA;
import main.java.nfa.NFATransitions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFAManager {
    private final String name;
    private final String type;
    private final JsonObject tuple;
    private final List<String> pass_cases;
    private final List<String> fail_cases;
    private final FACreator creator = dfaCreator();

    public DFAManager(String name, String type, JsonObject tuple, List<String> pass_cases, List<String> fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    private FACreator dfaCreator() {
        return new FACreator() {
            @Override
            public DFA create(List<String> states, List<String> alphabets, HashMap<String, HashMap> delta, String startState, List<String> finalStates) {
                return null;
            }
        };
    }

    public DFARunner createRunner(FACreator creator) {

        if (type.equals("dfa")) {
            Tuple t = new Gson().fromJson(tuple.toString(), Tuple.class);
            return new DFARunner(name, t.getDFA(creator), pass_cases, fail_cases, type);
        } else if (type.equals("nfa")) {
            Tuple t = new Gson().fromJson(tuple.toString(), Tuple.class);
            return new DFARunner(name, t.getDFA(new FACreator() {
                @Override
                public FA create(List<String> states, List<String> alphabets, HashMap<String, HashMap> delta, String startState, List<String> finalStates) {
                    Set<String> finalSet = new HashSet<>(finalStates);
                    NFATransitions nfaTransitions = new NFATransitions();
                    nfaTransitions.addAll(delta);
                    return new NFA(nfaTransitions, startState, finalSet);
                }
            }), pass_cases, fail_cases, type);
        }
        return null;
    }
}
