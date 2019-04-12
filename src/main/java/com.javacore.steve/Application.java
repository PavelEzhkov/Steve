package com.javacore.steve;

import com.javacore.steve.helpers.CommandParser;
import com.javacore.steve.profile.ProfileController;
import com.javacore.steve.state.ApplicationState;
import com.javacore.steve.state.StateIdle;

import java.util.Scanner;

/**
 * Application is the main entity will be using to start work with Steve
 *
 * @author Pavel Ezhkov
 * @version 0.0.2
 */

public class Application {
    public static final String APP_NAME = "Steve";
    public static final String AUTHOR = "Pavel Ezhkov";
    public static final String VERSION = "0.0.2";
    private static ApplicationState currentState;

    public static void main(String[] args) {
        ProfileController profileController = new ProfileController();
        profileController.showProfile(6);


        /*changeState(new StateIdle(), "idle");
        Scanner scanner = new Scanner(System.in);
        String commandName;

        while (true) {
            String newString = scanner.nextLine();
            commandName = CommandParser.pars(newString.toLowerCase());
            //System.out.println(commandName);
            if (commandName.equals("bye"))
                break;
            currentState.onCommand(commandName);
        }*/
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        currentState.enter(commandName);
    }

}
