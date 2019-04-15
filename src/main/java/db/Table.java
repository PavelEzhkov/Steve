package db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class Table {

    private String name;

    private List<String> columns;

    private List<Record> records;
    {
        records = new ArrayList<>();
    }

    public Table(String name, List<String> columns){
        this.name = name;
        this.columns=columns;
    }

    public  void insert(Record record){
        records.add(record);
    }
    // query SELECT id, firstName, lastName
    public void select(String query){};
    //--------
    // id   firstName   lastName
    //-------------------------------------------
    // 1    Vladimir    Trump
    // должна работать в отдельном потоке и делать это 1000 мс

    public  List<String> selectField(String fieldName){
        int index = columns.indexOf(fieldName);
        Iterator it = records.iterator();
        List<String> result = new ArrayList<>();
        while (it.hasNext()){
            Record r = (Record) it.next();
            result.add(r.values.get(index));
        }
        return result;
    }
    //

}
