package com.javacore.steve.commands;

/**
 * Extend {@link ACommand} to show commands list
 */

public class CommandHelp extends ACommand {


    public CommandHelp(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        CommandRegistry.INSTANCE.listCommands();
    }
}
