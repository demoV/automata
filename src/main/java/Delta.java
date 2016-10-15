package main.java;

import com.google.gson.JsonObject;

public class Delta {
    private JsonObject delta;

    public Delta() {
        System.out.println("ara hai kya");
    }

    public Delta(JsonObject delta) {
        this.delta = delta;
    }

    public void show() {
        System.out.println("delta = " + delta);
    }

    @Override
    public String toString() {
        return "Delta{" +
                "delta=" + delta +
                '}';
    }
}
