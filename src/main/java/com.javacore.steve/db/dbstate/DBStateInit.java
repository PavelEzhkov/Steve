package com.javacore.steve.db.dbstate;


import com.javacore.steve.db.DBApplication;
import com.javacore.steve.db.data.Table;
import com.javacore.steve.db.data.TableMetaData;
import com.javacore.steve.db.misc.DBConstants;
import com.javacore.steve.db.misc.DataHandler;
import com.javacore.steve.db.misc.Utils;
import com.javacore.steve.db.server.DBServer;

public class DBStateInit extends DBState {
    public DBStateInit(String name) {
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();
        try {
            DBServer.INSTANCE.start();
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
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}