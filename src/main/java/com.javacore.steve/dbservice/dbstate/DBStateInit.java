package com.javacore.steve.dbservice.dbstate;


import com.javacore.steve.dbservice.DBApplication;
import com.javacore.steve.dbservice.data.Table;
import com.javacore.steve.dbservice.data.TableMetaData;
import com.javacore.steve.dbservice.misc.DBConstants;
import com.javacore.steve.dbservice.misc.DataHandler;
import com.javacore.steve.dbservice.misc.Utils;
import com.javacore.steve.dbservice.server.DBServer;

import java.util.ArrayList;
import java.util.List;

public class DBStateInit extends DBState {

    private List<Table> tables = new ArrayList<>();

    public DBStateInit(String name) {
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();
        try {
            DBServer.INSTANCE.start(tables);
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateRun);
        } catch (Exception e) {
            e.printStackTrace();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
        }
    }

    private void initTables() {
        Utils.readDir(DBConstants.TABLE_DIR, new DataHandler() {
            @Override
            public void handleFile(String filePath) {
                TableMetaData metaData = TableMetaData.loadFromFile(filePath);
                Table table = new Table(metaData);
                table.load();
                tables.add(table);
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}
