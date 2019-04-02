package com.javacore.steve.commands;

import java.util.HashMap;
import java.util.Map;

public enum CommandRegistry {
    INSTANCE;
    static Map<String, ACommand> commands;

    static {
        commands = new HashMap<>();
        commands.put("help", new CommandHelp("help", " - show all commands"));
        CommandAuthor commandAuthor = new CommandAuthor("author", " - prints author name ");
        commands.put("author", commandAuthor);
        commands.put("creator", commandAuthor);
        commands.put("father", commandAuthor);
        commands.put("version", new CommandVersion("version", " - prints current version"));
    }

    /*public boolean hasCommand(String name) {
        return commands.containsKey(name);
    }*/

    public ACommand getCommands(String name) {
        return commands.get(name);
    }

    public void listCommands() {
        for (Map.Entry<String,ACommand> entry : commands.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().getDescription());
        }
        System.out.println("Bye - exit programme");
    }
}
