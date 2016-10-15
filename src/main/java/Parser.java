package main.java;


import com.google.gson.Gson;

public class Parser {
    public DFAInput toDFAInput(String jsonString) {
        return new Gson().fromJson(jsonString, DFAInput.class);
    }
}
