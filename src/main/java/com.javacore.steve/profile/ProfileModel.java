package com.javacore.steve.profile;

import com.javacore.steve.common.BaseModel;
import db.Record;

import java.util.Date;

public class ProfileModel extends BaseModel {
    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private int crimeFamelyId;
    private Date dateOfBirth;
    private boolean deseased;
    private Date dateOfDeath;
    private int numberOfCrimes;

    public static ProfileModel randomModel() {
        int rId = (int) (10 * Math.random());
        boolean rActive = rId % 2 == 0;
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmer_" + rId;
        return new ProfileModel(rId, rFirstName, rLastName, rActive);
    }

    public ProfileModel(){}

    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deseased = active;
    }

    public static ProfileModel modelFromRecord(Record record){
        ProfileModel model = new ProfileModel();
        try {
            model.setDeceased(record.getBoolean("deceased")).setId(record.getInt("id"));

        } catch (Record.FileNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }

    public ProfileModel setDeceased(boolean deseased){
        this.deseased = deseased;
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

    public boolean isActive() {
        return deseased;
    }

    public void setActive(boolean active) {
        this.deseased = active;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
