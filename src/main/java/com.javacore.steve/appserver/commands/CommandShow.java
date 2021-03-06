package com.javacore.steve.appserver.commands;

import com.javacore.steve.consolservice.common.ConsoleCanvas;

import com.javacore.steve.appserver.profile.ProfileModel;
import com.javacore.steve.consolservice.profile.ProfileView;

import java.util.GregorianCalendar;

public class CommandShow extends ACommand {
    private final int id;

    /**
     * Setter method
     *
     * @param name        command name
     * @param description command description
     */
    public CommandShow(String name, String description, int id) {
        super(name, description);
        this.id = id;
    }

    @Override
    public void execute() {
       // Record record = new Record();

        ProfileModel profileModel = new ProfileModel(1,"TestName","TestLastName", "Nick",1,new GregorianCalendar(1900,11,1),false,
                new GregorianCalendar(1925,6,11),10);
        ProfileView profileView = new ProfileView(profileModel);
        profileView.init();
        profileView.draw(new ConsoleCanvas(80,200));
    }
}
