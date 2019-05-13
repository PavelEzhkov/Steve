package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

public class ApiGETTestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.getRequestHeaders().put("Content-Type", Collections.singletonList("text/plain"));
        httpExchange.sendResponseHeaders(200,0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(WebClientApplication.APP_NAME.getBytes());
        os.close();
    }
}
