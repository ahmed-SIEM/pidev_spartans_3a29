package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import models.Reservation;
import models.Terrain;
import services.ReservationService;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import static models.TypeReservation.ReserverTerrainPourEquipe;

public class ReservationController implements Initializable {

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<Terrain, Integer> duree;

    @FXML
    private TextField heure;

    @FXML
    private TableColumn<Terrain, String> localisation;

    @FXML
    private TableColumn<Terrain, String> nomTerrain;

    @FXML
    private SplitMenuButton nom_equipe;

    @FXML
    private MenuItem nom_equipe1;

    @FXML
    private MenuItem nom_equipe2;

    @FXML
    private TableColumn<?, ?> prix;

    @FXML
    private TableColumn<Terrain, Checkbox> reserver;

    public boolean verfierHeure(String horaire) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime heure = LocalTime.parse(horaire, formatter);
            return (heure.isAfter(LocalTime.of(7, 59)) && heure.isBefore(LocalTime.of(23, 0)));
        } catch (Exception e) {
            return false;
        }
    }
    public boolean verfierDate(DatePicker datepicker){
        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateSelectionnee = datepicker.getValue();
        return dateSelectionnee != null && dateSelectionnee.isAfter(dateActuelle);
    }

    public String convertirDateEnString(DatePicker datepicker){
        LocalDate dateSelectionnee = datepicker.getValue(); ;
        if (dateSelectionnee != null) {
            return dateSelectionnee.toString();
        } else {
            return null;
        }
    }



    public void add(ActionEvent event) throws SQLException {
        if(verfierHeure(heure.getText()) && verfierDate(datepicker)){
            String date = convertirDateEnString(datepicker);
            //                                                                    a ajouter id terrain
            int idt = 1 ;
            Reservation r1 = new Reservation(false,date,heure.getText(),ReserverTerrainPourEquipe ,idt);
            ReservationService reservationService = new ReservationService();
            reservationService.ajouterReservation(r1);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
