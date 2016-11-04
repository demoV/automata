package main.java;

import java.util.HashMap;

public class MyDelta {
    private HashMap<String, HashMap> delta;

    public MyDelta(HashMap<String, HashMap> delta) {
        this.delta = delta;
    }

    public HashMap<String, HashMap> getDelta() {
        System.out.println("delta = " + delta);
        return delta;
    }
}
