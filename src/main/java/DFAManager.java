package main.java;

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

    public DFARunner createRunner(DFAGenerator generator) {
        return new DFARunner(name, tuple.getDFA(generator), pass_cases, fail_cases);
    }
}
