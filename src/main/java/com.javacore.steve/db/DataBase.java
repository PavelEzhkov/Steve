package com.javacore.steve.db;

import com.javacore.steve.helpers.CommandParser;

import java.io.*;
import java.util.*;

public class DataBase {

    Map<String, Table> tables = new HashMap<>();


    public void setTables(String tableName, Table table) {
        this.tables.put(tableName, table);
    }


    public void selectAndPrint(final String query) {
        final List<String> request = new ArrayList<>(CommandParser.INSTANCE.parsSQLRequest(query));
        String whereColumn= null;
        String whereValue = null;
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
            final Thread thread = new Thread() {
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
                    table.selectAndPrint(request, finalWhereColumn, finalWhereValue);
                }
            };
            System.out.print("\nLoading from database: " + tableName);
            thread.start();
        } else System.out.println("Query isn't correct, need From argument");
    }

//переписать на примере лекции
    public  List<Record> select(String query) {
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

    public void update() {

    }


    public static Table readTable (String tableName,String fileName){
        List<List<String>> list = DataBase.readDataFile(fileName);
        Table table = new Table(tableName, list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Record record = new Record(table);
            record.setValues(list.get(i));
            table.insert(record);
        }
        return table;
    }

    private static List<List<String>> readDataFile(String fileName){
        FileInputStream fis = null;
        BufferedReader bis;
        List<List<String>> result = new ArrayList<>();
        try {
            fis = new FileInputStream(fileName);
            bis= new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line=bis.readLine())!=null){
                result.add(Arrays.asList(line.split(";")));
            }
        } catch (IOException fnf) {
            fnf.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void delete() {

    }

    public void insert(Record record, Table table) {

    }
}
/*

    private Object tableLock = new Object();

    public  List<Record> selectAndPrint() {
        System.out.println("Starting fetching records");
        synchronized (tableLock) {
            try {
                Thread.sleep(500);
                System.out.println("Finished fetched records");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void update() {
        System.out.println("Starting updating DB");
        synchronized (tableLock) {
            try {
                Thread.sleep(10000);
                System.out.println("Finished updating DB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

 */