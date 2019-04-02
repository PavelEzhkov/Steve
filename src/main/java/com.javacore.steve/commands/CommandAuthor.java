package com.javacore.steve.commands;

import com.javacore.steve.Application;

public class CommandAuthor extends ACommand {


    public CommandAuthor(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("My author is " + Application.AUTHOR);
    }
}
