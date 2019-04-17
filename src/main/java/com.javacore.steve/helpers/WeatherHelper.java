package com.javacore.steve.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.util.HashMap;
import java.util.Map;

public class WeatherHelper {


    public static Map<String,Object> jsonToMap(String string){
        Map<String, Object> map = new Gson().fromJson(string, new TypeToken<HashMap<String,Object>>(){}.getType());
        return map;
    }

    private static final String API_KEY ="4f850c64b1fab5268c29242452d686ab";
    private static final String LOCATION =",Ru";
    //private  String urlString ="https://samples.openweathermap.org/data/2.5/forecast?q=" + LOCATION + "&appid=" + API_KEY;
    private  String urlString ="https://samples.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY;

    public WeatherHelper()  {




    }
    /*public WeatherHelper(){
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=reader.readLine())!= null){
                result.append(line);
            }
            reader.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            //Map<String, Object> listMap = jsonToMap(respMap.get("list").toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

            System.out.printf("Temperature is %.2f \n",  ((double)mainMap.get("temp")-273.17));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
