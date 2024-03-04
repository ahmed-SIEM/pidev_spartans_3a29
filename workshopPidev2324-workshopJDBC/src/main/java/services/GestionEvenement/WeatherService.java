package services.GestionEvenement;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherService {

    private static final String API_KEY = "f58bc9aeffc02411af6db2e51c7b6061";

    public static String get5DayForecast(double latitude, double longitude) {
        String uri = String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&units=metric&appid=%s", latitude, longitude, API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données météo.";
        }
    }
}

