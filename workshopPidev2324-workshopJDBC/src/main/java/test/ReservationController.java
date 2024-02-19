package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import models.Reservation;
import models.Terrain;

import java.awt.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm");
        sdf.setLenient(false);
        try {

            Date date = sdf.parse(horaire);

            Date plageDebut = sdf.parse("08h00");
            Date plageFin = sdf.parse("23h59");


            return !date.before(plageDebut) && !date.after(plageFin);
        } catch (ParseException e) {

            return false;


        }
    }

    public static int i ;
    public void add(ActionEvent event) {



        if(verfierHeure(heure.getText())){
            Reservation r1 = new Reservation(false,this.datepicker.getValue().toString(),heure.getText(),ReserverTerrainPourEquipe);
        //r1.getListTerrain().add();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
