package services;

import models.Paiement;
import utils.MyDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaiementService {
    private Connection connection;
    public PaiementService(){
        connection = MyDatabase.getInstance().getConnection();
    }


    private static final String API_KEY = "65da01394e8dd3df3f8b75c8:dK6rN27wwEjg7L9vA8tC";
    private static final String API_URL = "https://api.preprod.konnect.network/api/v2/payments/init-payment";

    public static String initiatePayment(String jsonData) throws IOException, MalformedURLException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("x-api-key", API_KEY);
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }



    public boolean AjouterPaiement(Paiement paiement) throws SQLException {
        String query = "INSERT INTO Payment (idMembre, idReservation, datePayment, horairePayment,Payed) VALUES (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, paiement.getIdmembre());
        ps.setInt(2, paiement.getIdreservation());
        ps.setString(3, paiement.getDate());
        ps.setString(4, paiement.getHeure());
        ps.setBoolean(5,false);

        ps.setInt(5, 1);

        ps.executeUpdate();
        int lignesAffectees = ps.executeUpdate();

        return lignesAffectees > 0;


    }
    public boolean confirmerPaiment(int idpaiement){
        String query = "UPDATE payment SET Payed = TRUE WHERE idPayment = ?;";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, idpaiement);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
