package com.javacore.steve.commands;

public class CommandWeather extends ACommand {
    CommandWeather(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I can't do it yet");
    }
}
