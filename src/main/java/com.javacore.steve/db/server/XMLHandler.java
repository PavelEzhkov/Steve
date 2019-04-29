package com.javacore.steve.db.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.Arrays;

public class XMLHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        FileInputStream fis = new FileInputStream("database/structure/test.xml");
        String state="";
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            state +=line;
        }
        } finally {
            fis.close();
        }
        httpExchange.sendResponseHeaders(200, state.length());
        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/xml"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(state.getBytes());
        os.close();
    }
}
