package main.java;

import com.google.gson.Gson;

import java.util.List;

public class DFAManager {
    private static final Gson gson = new Gson();
    private final String name;
    private final String type;
    private final Tuple tuple;
    private final List<String> passCases;
    private final List<String> failCases;


    public DFAManager(String name, String type, Tuple tuple, List<String> passCases, List<String> failCases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.passCases = passCases;
        this.failCases = failCases;
    }

    public DFARunner createRunner(DFAGenerator generator) {
        return new DFARunner(name, tuple.getDFA(generator), passCases, failCases);
    }
}
