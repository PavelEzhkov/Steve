package com.javacore.steve.db.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class XMLHandlerShow implements HttpHandler {
    private final String state;

    public XMLHandlerShow(String state) {
    this.state= state;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, state.length());
        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/xml"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(state.getBytes());
        os.close();
    }
}
