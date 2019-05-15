package com.javacore.steve.appserver.profile;

import com.javacore.steve.appserver.common.BaseModel;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ProfileModel extends BaseModel {
    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private int crimeFamelyId;
    private GregorianCalendar dateOfBirth;
    private boolean deceased;
    private GregorianCalendar dateOfDeath;
    private int numberOfCrimes;


    public ProfileModel(){}

    public ProfileModel(int id, String firstName, String lastName, String nickname, int crimeFamelyId, GregorianCalendar dateOfBirth, boolean deceased, GregorianCalendar dateOfDeath, int numberOfCrimes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.crimeFamelyId = crimeFamelyId;
        this.dateOfBirth = dateOfBirth;
        this.deceased = deceased;
        this.dateOfDeath = dateOfDeath;
        this.numberOfCrimes = numberOfCrimes;
    }

    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deceased = active;
    }
/*
    public static ProfileModel modelFromRecord(Record record){
        ProfileModel model = new ProfileModel();
        try {
            model.setDeceased(record
                    .getBoolean("deceased"))
                    .setId(record.getInt("id"));

        } catch (Record.FileNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }*/

    public ProfileModel setDeceased(boolean deseased){
        this.deceased = deseased;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        Format dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dateOfBirth.getTime());
    }

    public boolean isActive() {
        return deceased;
    }

    public void setActive(boolean active) {
        this.deceased = active;
    }


    public String getDateOfDeath() {
        Format dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dateOfDeath.getTime());
    }

    public String getNickname() {
        return nickname;
    }

    public int getCrimeFamelyId() {
        return crimeFamelyId;
    }

    public int getNumberOfCrimes() {
        return numberOfCrimes;
    }
}
