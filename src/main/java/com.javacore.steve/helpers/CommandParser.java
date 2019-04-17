package com.javacore.steve.helpers;

import com.javacore.steve.commands.CommandRegistry;

import java.util.Arrays;
import java.util.List;

public enum  CommandParser {
    INSTANCE;

    public static String pars(String commandName) {
        String[] words = commandName.split(" ");
        for (String string : words
        ) {
            if (string.equals("bye")) return "bye";
            else if (CommandRegistry.INSTANCE.hasCommand(string)) return string;
        }
        return "help";
    }

     public List<String> parsSQLRequest(String request){

        List<String> result = Arrays.asList(request.toLowerCase().split(" = |, |,| "));

        return result;
     }
}
