package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

public class JsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        File file = new File("webclient"+path);
        byte[] fileBytes = null;

        if (file.exists()){
            fileBytes = Utils.readBytes("webclient"+path);
        }

        httpExchange.getRequestHeaders().put("Content-Type", Collections.singletonList("application/javascript"));
        httpExchange.sendResponseHeaders(200,0);
        OutputStream os = httpExchange.getResponseBody();
        if(fileBytes != null){
            os.write(fileBytes);
        }
        os.close();
    }
}
