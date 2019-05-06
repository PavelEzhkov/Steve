package com.javacore.steve.dbservice.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class XMLHandler implements HttpHandler {
    private List<String> fileSource;

    XMLHandler(List<String> fileSource) {
        this.fileSource= fileSource;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        StringBuilder state = new StringBuilder();
        state.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        state.append("<database>");
        for (String s : fileSource) {
            try (FileInputStream fis = new FileInputStream(s)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.contains("?"))state.append(line);
                }
            }
        }
        state.append("</database>");
        httpExchange.sendResponseHeaders(200, state.length());
        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/xml"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(state.toString().getBytes());
        os.close();
    }
}
