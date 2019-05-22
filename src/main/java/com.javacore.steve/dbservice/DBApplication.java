package com.javacore.steve.dbservice;


import com.javacore.steve.dbservice.data.Table;
import com.javacore.steve.dbservice.data.query.QueryResult;
import com.javacore.steve.dbservice.dbstate.DBState;
import com.javacore.steve.dbservice.dbstate.DBStateInit;
import com.javacore.steve.dbservice.dbstate.DBStateRunning;
import com.javacore.steve.dbservice.dbstate.DBStateStop;

import com.javacore.steve.dbservice.test.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public enum DBApplication {
    INSTANCE;

    // List<Table> tables;
    private Map<String, Table> tables = new HashMap<>();

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
        boolean testEnabled = Boolean.valueOf(System.getProperty("et"));
        if (testEnabled) {
            try {
                runTests("com.javacore.steve.dbservice.test.WHERETest");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //     changeState(stateInit);

    }

    private void runTests(String classNAme) throws Exception {
        int passed = 0;
        int failed = 0;
        for (Method m: Class.forName(classNAme).getMethods()){
            Test testAnnotation = m.getAnnotation(Test.class);
            if (testAnnotation != null && testAnnotation.enabled()){
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex){
                    System.out.printf("Test %s failed: %s \n", m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d", passed, failed);
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

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }


    // old xml
//    public String selectXML(String query) {
//        StringBuilder result = new StringBuilder();
//        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        List<String> queryList = CommandParser.pars(query);
//        for (Table t : tables
//        ) {
//            if (t.getMetaData().getTableName().equals(queryList.get(TABLE_NAME))) {
//                result.append("<table name=\"").append(queryList.get(TABLE_NAME)).append("\">").append("<rows>");
//                List<String> columns = Arrays.asList(queryList.get(COLUMNS_NAMES).split(", |,"));
//                List<TableRow> values = t.select(columns);
//                TableMetaData tableMetaData = t.selectMetaData(columns);
//                int start = 0;
//                int size = values.size();
//                if (queryList.contains("WHERE")) {
//                    List<String> whereList = Arrays.asList(queryList.get(WHERE).split(" = "));
//                    int columnNumber = -1;
//                    for (int i = 0; i < tableMetaData.getColumns().size(); i++) {
//                        if (tableMetaData.getColumns().get(i).getName().equals(whereList.get(WHERE_NAME))) {
//                            columnNumber = i;
//                        }
//                    }
//                    for (int i = 0; i < values.size(); i++) {
//                        if (values.get(i).getValues().get(columnNumber).equals(whereList.get(WHERE_VALUE))) {
//                            start = i;
//                            size = i + 1;
//                        }
//                    }
//                }
//                for (int i = start; i < size; i++) {
//                    result.append("<row>");
//                    for (int j = 0; j < tableMetaData.getColumns().size(); j++) {
//                        result.append("<column systemName=\"").append(tableMetaData.getColumns().get(j).getName())
//                                .append("\" displayName=\"").append(tableMetaData.getColumns().get(j).getDisplayName())
//                                .append("\" value=\"").append(values.get(i).getValues().get(j)).append("\"/>");
//                    }
//                    result.append("</row>");
//                }
//            }
//        }
//        result.append("</rows>").append("</table>");
//        return result.toString();
//    }

}
