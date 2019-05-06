package com.javacore.steve.dbservice.data;


import com.javacore.steve.dbservice.misc.DataHandler;
import com.javacore.steve.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<TableRow> rows;

    private TableMetaData metaData;

    public Table(TableMetaData metaData) {
        this.metaData = metaData;
        rows = new ArrayList<>();
    }

    public void load() {
        Utils.readFileLineByLine(metaData.getPathToData(), new DataHandler() {
            @Override
            public void handleString(String line) {
                TableRow row = new TableRow();
                row.setValues(line);
                addRow(row);
            }
        });
        System.out.println("Table loaded: " + this.metaData.getTableName() + " contains " + rows.size() + " rows");
    }

    public void save() {
    }

    public List<TableRow> select(List<String> columns) {
        if (columns.get(0).equals("*"))
            return rows;
        List<TableRow> result = new ArrayList<>();
        for (TableRow tR : rows
        ) {
            List<String> values = tR.getValues();
            TableRow tableRow = new TableRow();
            List<String> valuesTableRow = new ArrayList<>();
            for (String s : columns
            ) {
                for (int i = 0; i < metaData.getColumns().size(); i++) {
                    if (metaData.getColumns().get(i).getName().equals(s)) {
                        valuesTableRow.add(values.get(i));
                    }
                }
            }
            tableRow.setValues(valuesTableRow);
            result.add(tableRow);
        }
        return result;
    }

    public TableMetaData selectMetaData(List<String> columns) {
        if (columns.get(0).equals("*"))
            return metaData;
        TableMetaData tableMetaData = new TableMetaData();
        for (String s : columns
        ) {
            for (int i = 0; i < metaData.getColumns().size(); i++) {
                if (metaData.getColumns().get(i).getName().equals(s)) {
                    tableMetaData.addColumn(metaData.getColumns().get(i));
                }
            }
        }
        return tableMetaData;
    }


    public void addRow(TableRow row) {
        rows.add(row);
    }

    public TableMetaData getMetaData() {
        return metaData;
    }

    @Override
    public String toString() {
        String result = "\n" + metaData.getTableName();
        result += "\nStructure file: " + metaData.getPathToStructure();
        result += "\nData file: " + metaData.getPathToData();
        result += "\n" + metaData.getColumns();
        result += "\nnumber of rows: " + rows.size();
        return result;
    }
}
