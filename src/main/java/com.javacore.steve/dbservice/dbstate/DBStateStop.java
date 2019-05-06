package com.javacore.steve.dbservice.dbstate;


import com.javacore.steve.dbservice.misc.DBConstants;
import com.javacore.steve.dbservice.misc.MainDataEncryptor;
import com.javacore.steve.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

    public DBStateStop(String name) {
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBStop state");

        List<String> list = new ArrayList<>();
        list.add("test string one");
        list.add("test string two");
        Utils.writeListToFile(list, DBConstants.DATA_DIR + "/test.dat", new MainDataEncryptor());
    }

    @Override
    public void onStop() {
        System.out.println("Already trying to stop...");
    }
}
