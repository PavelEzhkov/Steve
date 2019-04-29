package com.javacore.steve.db.server;

import com.javacore.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;

public enum  DBServer {
    INSTANCE;
    public static final int PORT = 6701;


    public void start() throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/db/structure", new XMLHandler());
        server.createContext("/db/state", new StateHandler());
        server.start();
        String massage = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(massage);
    }
}
