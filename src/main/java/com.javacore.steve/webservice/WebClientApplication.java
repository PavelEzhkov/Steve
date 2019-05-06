
package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;


public enum WebClientApplication {
    INSTANCE;
    public static final int PORT = 6703;
    public static final String APP_NAME = "Web client Service";

    public void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10);
        server.createContext("/pages/", new HtmlHandler());
        server.createContext("/static", new CssHandler());
        server.start();
        String massage = String.format("%s is running on port: %d", APP_NAME, server.getAddress().getPort());
        System.out.println(massage);
    }
}
