package com.javacore.steve.appserver.commands;

/**
 * Extend {@link ACommand} to show commands list
 */

public class CommandHelp extends ACommand {


    public CommandHelp(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("I can do this commands. Maybe i understand this in context, but you should separate the command with spaces.");
        CommandRegistry.INSTANCE.listCommands();
    }
}
