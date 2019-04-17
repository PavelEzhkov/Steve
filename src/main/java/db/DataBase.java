package db;

import com.javacore.steve.helpers.CommandParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    Map<String, Table> tables = new HashMap<>();

    public DataBase(String tableName, Table table) {
        this.tables.put(tableName, table);
    }


    //DB.query("Select id, Name, lastName from Criminals  дополнитекльно+ WHERE ID =? )


    public List<Record> select() {
        return null;
    }

    public void select(final String query) {
        final List<String> request = new ArrayList<>(CommandParser.INSTANCE.parsSQLRequest(query));
        String whereColumn= null;
        String whereValue = null;
        if (request.contains("where"))
        {
            whereColumn = request.get(request.indexOf("where") + 1);
            whereValue = request.get(request.indexOf("where") + 2);
            request.remove(request.indexOf("where") + 1);
            request.remove(request.indexOf("where") + 1);
            request.remove("where");
        }
        if (request.contains("from")) {
            final String tableName = request.get(request.indexOf("from") + 1);
            request.remove("from");
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
                    table.select(request, finalWhereColumn, finalWhereValue);
                }
            };
            System.out.print("\nLoading from database: " + tableName.toUpperCase());
            thread.start();
        } else System.out.println("Query isn't correct, need From argument");
    }


    public void update() {

    }

    public void delete() {

    }

    public void insert(Record record, Table table) {

    }
}
