package com.javacore.steve;

import com.javacore.steve.commands.ACommand;
import com.javacore.steve.commands.CommandRegistry;

import java.util.Scanner;

public class Application {
    public static final String APP_NAME = "Steve";
    public static final String AUTHOR = "Pavel Ezhkov";
    public static final String VERSION = "0.0.1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String commandName;
        while (true){
        commandName= scanner.next();
        if (commandName.equals("bye"))
            break;
        ACommand command = CommandRegistry.INSTANCE.getCommands(commandName);
        command.execute();}
    }
}
