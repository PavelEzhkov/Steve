package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;

public class HtmlHandler implements HttpHandler {

    public static final String HTML_FORMAT = "^/pages/(([a-zA-z]+\\.)(html))$";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String response = "";
        if (path.matches(HTML_FORMAT)){
            response = path;
        } else {
            response = "Invalid URL: " +path;
        }
        File file = new File("webclient"+path);
        response += "\n File Exist: "+ file.exists();

        byte[] fileBytes = null;

        if (file.exists()){
            fileBytes = Utils.readBytes("webclient"+path);
        }

        httpExchange.getRequestHeaders().put("Content-Type", Collections.singletonList("text/html"));
        httpExchange.sendResponseHeaders(200,0);
        OutputStream os = httpExchange.getResponseBody();
       // os.write(("Html Handler: " + response+"\n").getBytes());
        if(fileBytes != null){
            os.write(fileBytes);
        }
        os.close();
    }
}
