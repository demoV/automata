package main.java;


import com.google.gson.Gson;

public class Parser {
    public DFAManager toDFAInput(String jsonString) {
        return new Gson().fromJson(jsonString, DFAManager.class);
    }
}
