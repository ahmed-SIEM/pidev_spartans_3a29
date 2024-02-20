package services;

import models.Paiement;
import utils.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaiementService {
    private Connection connection;
    public PaiementService(){
        connection = MyDatabase.getInstance().getConnection();
    }
    public boolean payer(Paiement paiement) throws SQLException {
        String query = "INSERT INTO Payment (idMembre, idReservation, datePayment, horairePayment) VALUES (?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, paiement.getIdmembre());
        ps.setInt(2, paiement.getIdreservation());
        ps.setString(3, paiement.getDate());
        ps.setString(4, paiement.getHeure());

        ps.setInt(5, 1);

        ps.executeUpdate();
        int lignesAffectees = ps.executeUpdate();

        return lignesAffectees > 0;


    }
}
