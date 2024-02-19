package services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import models.Reservation;
import models.Terrain;
import models.TypeReservation;
import utils.MyDatabase;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static models.TypeReservation.ReserverTerrainPourEquipe;
/*implements IService<Reservation> */
public class ReservationService {
    private Connection connection;
    public ReservationService(){
        connection = MyDatabase.getInstance().getConnection();
    }/*
    public Reservation getById(int id){
        Reservation reservation = new Reservation();


    }*/


    public void ajouterReservation(Reservation reservation /*, List<Terrain> terrains */) throws SQLException {
        /*
        ********************************************************true
        for (int i = 0; i < terrains.size(); i++) {
            String query = "INSERT INTO reservation (isConfirm, dateReservation, heureReservation, type, idTerrain)\n" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1, false);
            ps.setString(2, reservation.getDateReservation());
            ps.setString(3, reservation.getHeureReservation());
            ps.setString(4, reservation.getType());

            ps.setInt(5, terrains.get(i).getId());

            ps.executeUpdate();
            */

        String query = "INSERT INTO reservation (isConfirm, dateReservation, heureReservation, type, idTerrain)\n" +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, false);
        ps.setString(2, reservation.getDateReservation());
        ps.setString(3, reservation.getHeureReservation());
        ps.setString(4, reservation.getType());

        ps.setInt(5, 1);

        ps.executeUpdate();




        }
        public Reservation getById(int id ) throws SQLException {
        Reservation reservation = new Reservation();
            String query = "SELECT * FROM reservation WHERE idReservation  = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reservation.setIdReservation(rs.getInt("idReservation"));
                reservation.setConfirm(rs.getBoolean("isConfirm"));
                reservation.setDateReservation(rs.getString("dateReservation"));
                reservation.setHeureReservation(rs.getString("heureReservation"));
                reservation.setType(TypeReservation.valueOf(rs.getString("type")));

            }
            return reservation;


        }
        public  void annulerReservation(int idReservation) throws SQLException {
            ReservationService reservationService =  new ReservationService();
            Reservation reservation = reservationService.getById(idReservation);


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTransformee = LocalDate.parse(reservation.getDateReservation(), formatter);
            LocalDate dateActuelle = LocalDate.now();
            if(dateTransformee.isEqual(dateActuelle)){

            }

        }
    }


