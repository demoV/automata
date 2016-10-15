package main.java;

import main.java.dfa.DFA;

import java.util.List;

public class DFARunner {
    private final DFA dfa;
    private final List<String> passCases;
    private final List<String> failCases;
    private String name;

    public DFARunner(String name, DFA dfa, List<String> passCases, List<String> failCases) {
        this.name = name;
        this.dfa = dfa;
        this.passCases = passCases;
        this.failCases = failCases;
    }

    public Boolean runAll() {
        Boolean passing = false;
        for (String passCase : passCases) {
            passing = dfa.isPassing(passCase);
            if (!passing) {
                return false;
            }
        }
        for (String failCase : failCases) {
            passing = !dfa.isPassing(failCase);
            if (!passing) {
                return false;
            }
        }
        return true;
    }
}
