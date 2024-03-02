package services.GestionEvenement;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServiceMeteo {

    private static final String API_KEY = "f58bc9aeffc02411af6db2e51c7b6061";
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static String getWeather(String city) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String uri = String.format(WEATHER_URL, city, API_KEY);

            HttpGet request = new HttpGet(uri);
            HttpResponse response = client.execute(request);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
