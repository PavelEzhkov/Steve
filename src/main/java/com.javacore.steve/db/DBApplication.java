package com.javacore.steve.db;


import com.javacore.steve.db.data.QueryResult;
import com.javacore.steve.db.dbstate.DBState;
import com.javacore.steve.db.dbstate.DBStateInit;
import com.javacore.steve.db.dbstate.DBStateRunning;
import com.javacore.steve.db.dbstate.DBStateStop;
import com.javacore.steve.helpers.CommandParser;

import java.util.ArrayList;
import java.util.List;

public enum DBApplication {
    INSTANCE;

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";
    private DBState currentState;
    public DBState stateInit = new DBStateInit();
    public DBState stateRun = new DBStateRunning();
    public DBState stateStop = new DBStateStop();

    public void start() {
        changeState(stateInit);
    }

    public void stop() {
        currentState.onStop();
    }

    public QueryResult query(String query) {
        return null;
    }

    public void changeState(DBState state) {
        if (currentState != null) {
            if (currentState.equals(state)) {
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = state;
        currentState.enter();
    }

    //переписать на примере лекции
    public List<Record> select(String query) {
        final List<String> request = new ArrayList<>(CommandParser.INSTANCE.parsSQLRequest(query));
        String whereColumn= null;
        String whereValue = null;
        List<Record> result = new ArrayList<>();
        if (request.contains("WHERE"))
        {
            whereColumn = request.get(request.indexOf("WHERE") + 1);
            whereValue = request.get(request.indexOf("WHERE") + 2);
            request.remove(request.indexOf("WHERE") + 1);
            request.remove(request.indexOf("WHERE") + 1);
            request.remove("WHERE");
        }
        if (request.contains("FROM")) {
            final String tableName = request.get(request.indexOf("FROM") + 1);
            request.remove("FROM");
            request.remove(tableName);
            final String finalWhereColumn = whereColumn;
            final String finalWhereValue = whereValue;

            Table table = tables.get(tableName);
            result = table.select(request, table, finalWhereColumn, finalWhereValue);
/*
            Thread thread = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.print(".");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("done");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Table table = tables.get(tableName);
                    result = table.select(request, table, finalWhereColumn, finalWhereValue);
                }
            };
            System.out.print("\nLoading from database: " + tableName);
            thread.start();*/
        } else System.out.println("Query isn't correct, need From argument");
        return result;
    }

}
