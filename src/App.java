import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static JSObject getWeatherData(String location){
        //get location  from api
        JSONArray locationData = getLocationData(location);

        return null;
    }

    public static JSONArray getLocationData(String location) {
        location = location.replaceAll(" ", "+");

        //building the api url with the location that will be provided
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" + location +
                "&count=10&language=en&format=json";

        try{
            HttpURLConnection connect = fetchApi(urlString);

            if(connect.getResponseCode() != 200){
                System.out.println("Cant Connect");
                return null;
            }
            else{

                //store the output of request
                StringBuilder result = new StringBuilder();
                Scanner scan = new Scanner(connect.getInputStream());

                //read and store the result into the string
                while(scan.hasNext()){
                    result.append(scan.nextLine());
                }

                scan.close();
                connect.disconnect();

                //string to object
                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(String
                        .valueOf(result));


                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                return locationData;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;


    }

    private static HttpURLConnection fetchApi(String urlString) {
        try{
            //connection created
            URL url = new URL(urlString);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();

            //using a get as request
            connect.setRequestMethod("GET");
            connect.connect();
            return connect;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
