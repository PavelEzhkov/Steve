package com.javacore.steve;

import com.javacore.steve.commands.CommandRegistry;

class CommandParser {

    static String pars(String commandName) {
        String[] words = commandName.split(" ");
        for (String string : words
        ) {
            if (string.equals("bye")) return "bye";
            else if (CommandRegistry.INSTANCE.hasCommand(string)) return string;
        }
        return "help";
    }
}
