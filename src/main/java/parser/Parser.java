package main.java.parser;


import com.google.gson.Gson;
import main.java.DFAManager;

public class Parser {
    public DFAManager toDfARunner(String jsonString) {
        String replace = jsonString.replaceAll("-", "_");
        return new Gson().fromJson(replace, DFAManager.class);
    }
}