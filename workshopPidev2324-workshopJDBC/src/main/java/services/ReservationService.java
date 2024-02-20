package services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import models.*;
import utils.MyDatabase;

import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static models.TypeReservation.ReserverTerrainPourEquipe;
/*implements IService<Reservation> */
public class ReservationService {
    private Connection connection;
    public ReservationService(){
        connection = MyDatabase.getInstance().getConnection();
    }


    public void ajouterReservation(Reservation reservation  /*,int idTerrain , List<Terrain> terrains */) throws SQLException {
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

        String query = "INSERT INTO reservation (isConfirm, dateReservation, heureReservation, type, idTerrain) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, false);
        ps.setString(2, reservation.getDateReservation());
        ps.setString(3, reservation.getHeureReservation());
        ps.setString(4, reservation.getType());
        ps.setInt(5, reservation.getIdTerrain());

        ps.executeUpdate();




        }

        // tous les reservations
        public List<Reservation> getAllReservation() throws SQLException {
            List<Reservation> reservations = new ArrayList<>();
            String query = "SELECT * FROM reservation ";
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setIdReservation(rs.getInt("idReservation"));
                reservation.setConfirm(rs.getBoolean("isConfirm"));
                reservation.setDateReservation(rs.getString("dateReservation"));
                reservation.setHeureReservation(rs.getString("heureReservation"));
                reservation.setType(TypeReservation.valueOf(rs.getString("type")));

                reservations.add(reservation);

            }
            return reservations ;


        }


        // pour l affichage dans la table par membre
        public List<Reservation> getReservationByIdMembre(int idm) throws SQLException {
            List<Reservation> reservations = new ArrayList<>();
            String query = "SELECT r.* FROM reservation r JOIN payment p ON r.idReservation = p.idReservation JOIN membre m ON p.idMembre = m.idMembre WHERE m.idMembre =  = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idm);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setIdReservation(rs.getInt("idReservation"));
                reservation.setConfirm(rs.getBoolean("isConfirm"));
                reservation.setDateReservation(rs.getString("dateReservation"));
                reservation.setHeureReservation(rs.getString("heureReservation"));
                reservation.setType(TypeReservation.valueOf(rs.getString("type")));

                reservations.add(reservation);

            }
            return reservations ;


        }

        // avoir l info d une reservation
        public Reservation getReservationByIdReservation(int id ) throws SQLException {
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
        //************************** appel de la partie blacklist dans la classe blacklistServices            a faire !
        public  void annulerReservation(int idReservation , int idMembre) throws SQLException {
            ReservationService reservationService =  new ReservationService();
            Reservation reservation = reservationService.getReservationByIdReservation(idReservation);


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTransformee = LocalDate.parse(reservation.getDateReservation(), formatter);
            LocalDate dateActuelle = LocalDate.now();
            if(dateTransformee.isEqual(dateActuelle)){
                BlackList blackList = new BlackList();
                blackList.setReservation(reservation);
                blackList.setIdTerrain(reservation.getIdTerrain());
                blackList.setCause("annulation apres 24h");
                blackList.setDuree(30);
                blackList.setIdMembre(idMembre);

                String query = "INSERT INTO blacklist (idReservation, idMembre, idTerrain, duree, cause) VALUES (?,?,?,?,?);";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, idReservation);
                ps.setInt(2, blackList.getIdMembre());
                ps.setInt(3, blackList.getIdMembre());
                ps.setInt(4, blackList.getDuree());
                ps.setString(5, blackList.getCause());

                ps.executeUpdate();


            }

        }
        // appel de l historique
        public void supprimerReservation(int idreservation) throws SQLException {

            String query = "DELETE FROM reservation WHERE idReservation = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idreservation);
            ps.executeUpdate();

        }

    }


