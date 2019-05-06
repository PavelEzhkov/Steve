package com.javacore.steve.dbservice;


import com.javacore.steve.dbservice.data.QueryResult;
import com.javacore.steve.dbservice.data.Table;
import com.javacore.steve.dbservice.data.TableMetaData;
import com.javacore.steve.dbservice.data.TableRow;
import com.javacore.steve.dbservice.dbstate.DBState;
import com.javacore.steve.dbservice.dbstate.DBStateInit;
import com.javacore.steve.dbservice.dbstate.DBStateRunning;
import com.javacore.steve.dbservice.dbstate.DBStateStop;
import com.javacore.steve.dbservice.server.DBServer;
import com.javacore.steve.helpers.CommandParser;

import java.util.Arrays;
import java.util.List;

public enum DBApplication {
    INSTANCE;

    List<Table> tables;

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";
    public static final int TABLE_NAME = 3;
    public static final int COLUMNS_NAMES = 1;
    public static final int WHERE = 5;
    public static final int WHERE_VALUE = 1;
    public static final int WHERE_NAME = 0;
    private DBState currentState;
    public DBState stateInit = new DBStateInit("Init");
    public DBState stateRun = new DBStateRunning("Running");
    public DBState stateStop = new DBStateStop("Stop");

    public void start() {
        changeState(stateInit);
        tables = DBServer.INSTANCE.getTables();
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

    public String getStateName() {
        return currentState.getName();
    }

    public String selectXML(String query) {
        StringBuilder result = new StringBuilder();
        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        List<String> queryList = CommandParser.pars(query);
        for (Table t : tables
        ) {
            if (t.getMetaData().getTableName().equals(queryList.get(TABLE_NAME))) {
                result.append("<table name=\"").append(queryList.get(TABLE_NAME)).append("\">").append("<rows>");
                List<String> columns = Arrays.asList(queryList.get(COLUMNS_NAMES).split(", |,"));
                List<TableRow> values = t.select(columns);
                TableMetaData tableMetaData = t.selectMetaData(columns);
                int start = 0;
                int size = values.size();
                if (queryList.contains("WHERE")) {
                    List<String> whereList = Arrays.asList(queryList.get(WHERE).split(" = "));
                    int columnNumber = -1;
                    for (int i = 0; i < tableMetaData.getColumns().size(); i++) {
                        if (tableMetaData.getColumns().get(i).getName().equals(whereList.get(WHERE_NAME))) {
                            columnNumber = i;
                        }
                    }
                    for (int i = 0; i < values.size(); i++) {
                        if (values.get(i).getValues().get(columnNumber).equals(whereList.get(WHERE_VALUE))) {
                            start = i;
                            size = i + 1;
                        }
                    }
                }
                for (int i = start; i < size; i++) {
                    result.append("<row>");
                    for (int j = 0; j < tableMetaData.getColumns().size(); j++) {
                        result.append("<column systemName=\"").append(tableMetaData.getColumns().get(j).getName())
                                .append("\" displayName=\"").append(tableMetaData.getColumns().get(j).getDisplayName())
                                .append("\" value=\"").append(values.get(i).getValues().get(j)).append("\"/>");
                    }
                    result.append("</row>");
                }
            }
        }
        result.append("</rows>").append("</table>");
        return result.toString();
    }

}
