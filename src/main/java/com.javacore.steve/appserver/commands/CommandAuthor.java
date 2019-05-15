package com.javacore.steve.appserver.commands;

import com.javacore.steve.Application;

/**
 * Extend {@link ACommand} to show author name
 */

public class CommandAuthor extends ACommand {


    public CommandAuthor(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("My author is " + Application.AUTHOR);
    }
}
