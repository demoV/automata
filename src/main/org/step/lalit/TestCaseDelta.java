package org.step.lalit;

import java.util.HashMap;

public class TestCaseDelta {
    private HashMap<String, HashMap> delta;

    public TestCaseDelta(HashMap<String, HashMap> delta) {
        this.delta = delta;
    }

    public HashMap<String, HashMap> getDelta() {
        return delta;
    }
}
