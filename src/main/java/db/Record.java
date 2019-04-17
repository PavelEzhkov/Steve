package db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {

    List<String> values;
    List<String> columns;

    {
        values= new ArrayList<>();
    }

    public Record(Table table){
        columns = table.getColumns();
    }

    public void setValues(String[] values){
        this.values.clear();
        this.values = Arrays.asList(values);
    }
    /*
    public Record(List<String> values){
        this.values=values;
    }*/

    public int getInt(String fieldName) throws FileNotFoundException{
         int index = columns.indexOf(fieldName);
         if (index==-1){
                throw  new FileNotFoundException("FIELD NOT FOUND: " + fieldName);
        }
        return Integer.parseInt(values.get(index));
    }

    public boolean getBoolean(String fieldName) throws  FileNotFoundException{
        int index = columns.indexOf(fieldName);
        if (index==-1){
            throw  new FileNotFoundException("FIELD NOT FOUND: " + fieldName);
        }
        return Boolean.parseBoolean(values.get(index));
    }

    public class FileNotFoundException extends Exception{
        public FileNotFoundException(String msg){
            super(msg);
        }
    }
}
