package com.javacore.steve;

import com.javacore.steve.commands.ACommand;
import com.javacore.steve.commands.CommandRegistry;
import com.javacore.steve.state.ApplicationState;
import com.javacore.steve.state.StateIdle;

import java.util.Scanner;

/**
 * Application is the main entity will be using to start work with Steve
 *
 * @author Pavel Ezhkov
 * @version 0.0.1
 */

public class Application {
    public static final String APP_NAME = "Steve";
    public static final String AUTHOR = "Pavel Ezhkov";
    public static final String VERSION = "0.0.1";
    private static ApplicationState currentState;

    public static void main(String[] args) {
        changeState(new StateIdle(),"idle");
        Scanner scanner = new Scanner(System.in);
        String commandName;

        while (true) {
            commandName = scanner.next().toLowerCase();
            if (commandName.equals("bye"))
                break;
            currentState.onCommand(commandName);
        }
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();}
            currentState = newState;
            currentState.enter(commandName);
        }

}
