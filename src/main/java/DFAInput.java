package main.java;

import com.google.gson.Gson;

import java.util.List;

public class DFAInput {
    private static final Gson gson = new Gson();
    private final String name;
    private final String type;
    private final Tuple tuple;
    private final List<String> passCases;
    private final List<String> failCases;

    public DFAInput(String name, String type, Tuple tuple, List<String> passCases, List<String> failCases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.passCases = passCases;
        this.failCases = failCases;
    }
}
