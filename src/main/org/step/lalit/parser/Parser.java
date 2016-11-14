package org.step.lalit.parser;


import com.google.gson.Gson;
import org.step.lalit.automata.DFAManager;

public class Parser {
    public DFAManager toDFAManager(String jsonString) {
        String replace = jsonString.replaceAll("-", "_");
        return new Gson().fromJson(replace, DFAManager.class);
    }
}
