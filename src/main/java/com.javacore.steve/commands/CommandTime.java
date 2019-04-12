package com.javacore.steve.commands;

import java.util.Date;

public class CommandTime extends ACommand {
    /**
     * Setter method
     *
     * @param name        command name
     * @param description command description
     */
    CommandTime(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        Date date = new Date();
        System.out.printf("It's %tT \n",date);
    }
}
