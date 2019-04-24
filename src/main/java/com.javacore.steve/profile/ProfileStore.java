package com.javacore.steve.profile;

import java.util.HashMap;
import java.util.Map;

public enum ProfileStore {
    INSTANSE;

    Map<Integer,ProfileModel> profiles;

    {
        profiles = new HashMap<>();
    }

    public ProfileModel getProfile(int id){
        return profiles.get(id);
    }
}
