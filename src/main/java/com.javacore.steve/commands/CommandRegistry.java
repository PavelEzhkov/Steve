package com.javacore.steve.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Contain all {@link ACommand} extended classes. Uses to manage command list
 */

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

    /**
     * Need to return command by name
     * @param name
     * @return command from map
     */

    public ACommand getCommands(String name) {
        return commands.get(name);
    }

    /**
     * Show all commands
     */
    public void listCommands() {
        for (Map.Entry<String,ACommand> entry : commands.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().getDescription());
        }
        System.out.println("Bye - exit programme");
    }
}
