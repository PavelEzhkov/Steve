package com.javacore.steve.db.server;


import com.javacore.steve.db.data.Table;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public enum DBServer {
    INSTANCE;
    public static final int PORT = 6701;


    private List<Table> tables = new ArrayList<>();

    public void showSelect(String select) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 10);
        server.createContext("/db/select", new XMLHandlerShow(select));
        server.start();
    }

    public void start(List<Table> tables) throws Exception {
        DBServer.INSTANCE.setTables(tables);
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        List<String> listOfTables = new ArrayList<>();
        for (Table table : tables) {
            listOfTables.add(table.getMetaData().getPathToStructure());
        }
        server.createContext("/db/structure", new XMLHandler(listOfTables));
        server.createContext("/db/state", new StateHandler());
        server.start();
        String massage = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(massage);
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
