package com.javacore.steve.appserver;

import com.javacore.steve.webservice.WebClientApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

public class CriminalsApiHandler implements HttpHandler {

    public static final String LIST_REQUEST = "^/api/criminals$";
    public static final String PERSON_REQUEST = "^/api/criminals/([0-9]+)$";


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String response = "";
        httpExchange.sendResponseHeaders(200,0);
        if (path.matches(LIST_REQUEST)){
            response = "LIST";
        } else if (path.matches(PERSON_REQUEST)){
            response = "PERSON";
        } else {httpExchange.sendResponseHeaders(400,0);}
        httpExchange.getRequestHeaders().put("Content-Type",Collections.singletonList("text/hml"));
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
