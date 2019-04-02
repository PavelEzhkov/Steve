package com.javacore.steve.commands;

public abstract class ACommand {
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public ACommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void execute(){
        System.out.println("I don’t understand your question");
    }
}
