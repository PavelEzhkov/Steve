package com.javacore.steve.appserver.commands;


import com.javacore.steve.consolservice.common.WeatherHelper;

public class CommandWeather extends ACommand {
    CommandWeather(String name, String description) {
        super(name, description);
    }



    @Override
    public void execute() {

        WeatherHelper helper = new WeatherHelper();
       /*
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I can't do it yet");*/
    }


}
