package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

public class ApiPostHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
       InputStream is = httpExchange.getRequestBody();
       byte[] requestBytes = new byte[is.available()];
       is.read(requestBytes);

        httpExchange.getRequestHeaders().put("Content-Type", Collections.singletonList("text/plain"));
        httpExchange.sendResponseHeaders(200,0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(requestBytes);
        os.close();
    }
}
