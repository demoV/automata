package main.java;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import main.java.dfa.DFA;

import java.util.HashMap;
import java.util.List;

public class DFAManager {
    private final String name;
    private final String type;
    private final JsonObject tuple;
    private final List<String> pass_cases;
    private final List<String> fail_cases;
    private final DFACreator creator = dfaCreator();

    public DFAManager(String name, String type, JsonObject tuple, List<String> pass_cases, List<String> fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    private DFACreator dfaCreator() {
        return new DFACreator() {
            @Override
            public DFA create(List<String> states, List<String> alphabets, HashMap<String, HashMap<String, String>> delta, String startState, List<String> finalStates) {
                return null;
            }
        };
    }

    public DFARunner createRunner(DFACreator creator) {
        if (type.equals("dfa")) {
            Tuple t = new Gson().fromJson(tuple.toString(), Tuple.class);
            return new DFARunner(name, t.getDFA(creator), pass_cases, fail_cases);
        }
        return null;
    }
}
