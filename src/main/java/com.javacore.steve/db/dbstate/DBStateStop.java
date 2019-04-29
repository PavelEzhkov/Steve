package com.javacore.steve.db.dbstate;


import com.javacore.steve.db.misc.DBConstants;
import com.javacore.steve.db.misc.MainDataEncryptor;
import com.javacore.steve.db.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

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
