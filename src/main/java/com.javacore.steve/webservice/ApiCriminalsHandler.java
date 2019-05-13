package com.javacore.steve.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ApiCriminalsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        //check path

        URL url = new URL ("http://localhost:6702/api/criminals");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String result = "";
        while ((line = bf.readLine()) != null){
            result += line;
        }
        bf.close();
        //send result to browser

    }
}
