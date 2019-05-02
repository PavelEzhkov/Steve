package com.javacore.steve.db.data;



import com.javacore.steve.db.misc.DBConstants;
import com.javacore.steve.db.misc.DataHandler;
import com.javacore.steve.db.misc.Utils;
import com.javacore.steve.db.misc.XMLDocumentHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TableMetaData {

    private static final String CFG_TABLE_NAME_OPTION = "name";
    private static final String CFG_TABLE_COLUMNS_OPTION = "columns";
    private static final String CFG_OPTION_SPLITTER = ": ";
    private static final String CFG_COLUMNS_SPLITTER = ";";

    private String pathToStructure;
    private String pathToData;
    private List<TableColumn> columns;
    private String tableName;

    public TableMetaData() {
        columns = new ArrayList<>();
    }

    public static TableMetaData loadFromFile(String fileName) {
        TableMetaData metaData = new TableMetaData();
        try {
            Utils.readXMLDocument(fileName, document -> {
                Element root = document.getDocumentElement();
                metaData.setTableName(root.getAttribute("name"));
                NodeList columns = root.getElementsByTagName("column");
                for (int i = 0; i < columns.getLength(); i++) {
                    Element column = (Element) columns.item(i);
                    metaData.addColumn(new TableColumn(column.getAttribute("systemName"), column.getAttribute("displayName")));
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
/*
        Utils.readFileLineByLine(fileName, new DataHandler() {
            @Override
            public void handleString(String line) {
                //TODO - refactor  handling
                String[] parts = line.split(CFG_OPTION_SPLITTER);
                if (parts[0].equals(CFG_TABLE_NAME_OPTION)) {
                    metaData.setTableName(parts[1]);
                }
                if (parts[0].equals(CFG_TABLE_COLUMNS_OPTION)) {
                    metaData.addColumns(parts[1]);
                }
            }
        });*/
        metaData.setPathToStructure(fileName);
        metaData.setPathToData(
            DBConstants.DATA_DIR + "\\" +
            metaData.getTableName() +
            DBConstants.DATA_EXT)
        ;
        return metaData;
    }

    public void addColumns(String columnString) {
        for (String columnName : columnString.split(CFG_COLUMNS_SPLITTER)) {
            addColumn(new TableColumn(columnName));
        }
    }

    public void addColumn(TableColumn column) {
        this.columns.add(column);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPathToData() {
        return pathToData;
    }

    public void setPathToData(String pathToData) {
        this.pathToData = pathToData;
    }

    public String getPathToStructure() {
        return pathToStructure;
    }

    public void setPathToStructure(String pathToStructure) {
        this.pathToStructure = pathToStructure;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "TableMetaData{" +
            "pathToStructure='" + pathToStructure + '\'' +
            ", pathToData='" + pathToData + '\'' +
            ", columns=" + columns +
            ", tableName='" + tableName + '\'' +
            '}';
    }
}
