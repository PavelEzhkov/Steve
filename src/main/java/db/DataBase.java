package db;

import java.util.List;
import java.util.Map;

public class DataBase {
    Map<String, Table> tables;
    //DB.query("Select id, Name, lastName from Criminals  дополнитекльно+ WHERE ID =? )


    public List<Record> select(){
        return null;
    }
    public void update(){

    }
    public void delete(){

    }

    public void insert (Record record, Table table){

    }
}
