package db;

import com.javacore.steve.helpers.CommandParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    Map<String, Table> tables = new HashMap<>();

    public DataBase() {

    }

    public DataBase(String tableName, Table table) {
        this.tables.put(tableName, table);
    }


    //DB.query("Select id, Name, lastName from Criminals  дополнитекльно+ WHERE ID =? )

    //my realization
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
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("done");
                    try {
                        Thread.sleep(500);
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

    private Object tableLock = new Object();

    public  List<Record> select() {
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

    public   void update() {
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

    public static List<String[]> readDataFile(String fileName){
        FileInputStream fis = null;
        BufferedReader bis;
        List<String[]> result = new ArrayList<>();
        try {
            fis = new FileInputStream(fileName);
            bis= new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line=bis.readLine())!=null){
                System.out.println(line);
                result.add(line.split(";"));
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
