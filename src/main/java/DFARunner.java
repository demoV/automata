package main.java;

import java.util.List;

public class DFARunner {
    private final FA fa;
    private final List<String> passCases;
    private final List<String> failCases;
    private String type;
    private String name;

    public DFARunner(String name, FA dfa, List<String> passCases, List<String> failCases, String type) {
        this.name = name;
        this.fa = dfa;
        this.passCases = passCases;
        this.failCases = failCases;
        this.type = type;
    }

    public Boolean runAll() {
        System.out.println("running: " + name + "type: " + type);
        Boolean passing;
        for (String passCase : passCases) {
            passing = fa.isAccepted(passCase);
            if (!passing) return false;
        }
        for (String failCase : failCases) {
            passing = !fa.isAccepted(failCase);
            if (!passing) return false;
        }
        return true;
    }
}
