package com.javacore.steve.commands;

/**
 * Abstract class uses to execute commands
 */


public abstract class ACommand {
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }
    /**Setter method
     * @param name command name
     * @param description command description
     */

    public ACommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void execute(){
        System.out.println("I don’t understand your question");
    }
}
