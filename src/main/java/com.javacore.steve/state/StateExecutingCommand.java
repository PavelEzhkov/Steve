package com.javacore.steve.state;

import com.javacore.steve.Application;
import com.javacore.steve.commands.ACommand;
import com.javacore.steve.commands.CommandRegistry;

public class StateExecutingCommand extends ApplicationState {
    @Override
    public void enter(String commandName) {
        System.out.println("Entering executing state");
        executeCommand(commandName);
    }

    private void executeCommand(String commandName) {
        ACommand command = CommandRegistry.INSTANCE.getCommands(commandName);
        command.execute();
        Application.changeState(new StateIdle(),"Idle");
    }

    @Override
    public void onCommand(String commandName) {
        System.out.println("Busy executing "+ commandName + "command, please wait");
    }

    @Override
    public void exit() {
        System.out.println("Exit state executing command");
    }
}
