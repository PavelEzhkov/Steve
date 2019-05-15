package com.javacore.steve.appserver.profile;

import com.javacore.steve.appserver.profile.ProfileModel;

import java.util.HashMap;
import java.util.Map;

public enum ProfileStore {
    INSTANSE;

    Map<Integer, ProfileModel> profiles;

    {
        profiles = new HashMap<>();
    }

    public ProfileModel getProfile(int id){
        return profiles.get(id);
    }
}
