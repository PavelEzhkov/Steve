package com.javacore.steve.db.server;

import com.javacore.steve.db.DBApplication;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class StateHandler implements HttpHandler {

    public static final String BAD_HTML =
            "<html>" +
                    "<head></head>" +
                    "<body><div style=\"background-color:#AAAA00; width: 100%; height:100%; border: 1px solid black; color:white;\">{{state}}</body>"+
                    "</html>";
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String state = BAD_HTML.replace("{{state}}", DBApplication.INSTANCE.getStateName());
        // state = String.format(BAD_HTML,state);
        httpExchange.sendResponseHeaders(200, state.length());
        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/html"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(state.getBytes());
        os.close();
    }
    //public void;
}
