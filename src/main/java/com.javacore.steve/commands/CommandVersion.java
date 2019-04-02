package com.javacore.steve.commands;

import com.javacore.steve.Application;

public class CommandVersion extends ACommand {

    public CommandVersion(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("My version is " + Application.VERSION);
    }
}
