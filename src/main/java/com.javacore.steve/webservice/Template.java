package com.javacore.steve.webservice;

import java.util.Map;

public class Template {
    public String templateFileName;
    public Map<String,String> values;

    public Template(String fileName, Map<String, String> values) {
        this.templateFileName = fileName;
        this.values = values;
    }

    public String compile(){
        String templateText = ""; //read file from disk
        for (String key: values.keySet()
             ) {
            templateText = templateText.replace("{{"+ key +"}}",values.get(key));
        }

        return templateText;
    }
}
