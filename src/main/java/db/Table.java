package db;

import com.javacore.steve.helpers.CommandParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    private String name;

    private List<String> columns;

    private List<Record> records;

    {
        records = new ArrayList<>();
    }

    public Table(String name, List<String> columns) {
        this.name = name.toLowerCase();
        this.columns = columns;
    }

    public void insert(Record record) {
        records.add(record);
    }

    void select(List<String> request, String whereColumn, String whereValue) {
        List<List<String>> result = new ArrayList<>();
        if (request.contains("select")) {
            for (int i = 1; i < request.size(); i++) {
                result.add(selectField(request.get(i)));
                System.out.printf(" %-15s |", request.get(i).toUpperCase());
            }
            System.out.println();
            for (int j = 0; j < request.size() - 1; j++) {
                System.out.print("------------------");
            }
            System.out.println();

            if (whereColumn != null) {
                int row = result.get(request.indexOf(whereColumn) - 1).indexOf(whereValue);
                for (List<String> helpList : result) {
                    System.out.printf(" %-15s |", helpList.get(row));
                }
            } else {
                for (int k = 0; k < result.get(0).size(); k++) {
                    for (List<String> helpList : result) {
                        System.out.printf(" %-15s |", helpList.get(k));
                    }
                    System.out.println();
                }
            }

        } else System.out.println("Query isn't correct, need Select argument");

    }

    private List<String> selectField(String fieldName) {
        int index = columns.indexOf(fieldName);
        Iterator it = records.iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            Record r = (Record) it.next();
            result.add(r.values.get(index));
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
