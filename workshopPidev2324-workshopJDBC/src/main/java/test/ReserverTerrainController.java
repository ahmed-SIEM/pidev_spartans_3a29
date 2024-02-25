package test;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import models.Reservation;
import models.Terrain;
import services.PaiementService;
import services.ReservationService;
import services.TerrainService;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static models.TypeReservation.ReserverTerrainPourEquipe;

public class ReserverTerrainController implements Initializable {



    @FXML
    private VBox Vbox1;

    @FXML
    private AnchorPane anchroPane2;

    @FXML
    private AnchorPane anchropane1;

    @FXML
    private Button buttonAccueil;

    @FXML
    private Button buttonActualites;

    @FXML
    private Button buttonEvenement;

    @FXML
    private Button buttonReservation;

    @FXML
    private DatePicker datepicker;

    @FXML
    private SplitMenuButton nom_equipe;
    @FXML
    private TextField heure;

    @FXML
    private Label horaireInvalides;
    @FXML
    private Label dateInvalide;


    public void initialize(URL location, ResourceBundle resources) {
        horaireInvalides.setVisible(false);
        dateInvalide.setVisible(false);
        showTerrains();
    }
// ajouter photo et video
    public void  showTerrains(){

        TerrainService ts = new TerrainService();
        ObservableList<Terrain> terrains = ts.getAllTerrains();
        Vbox1.getChildren().clear();

        Vbox1.getStyleClass().add("vbox-spacing");

        for (Terrain terrain : terrains){
            AnchorPane anchorPane3= new AnchorPane();
            HBox hBox = new HBox();
            anchorPane3.getStyleClass().add("anchor-pane-style");
            Label idLabel = new Label("Id: " + terrain.getId());
            Label nomLabel = new Label("Nom: " + terrain.getNomTerrain());
            Label addressLabel = new Label("Address: " + terrain.getAddress());
            Label gradinLabel = new Label("Gradin: " + terrain.getGradin());
            Label vestiaireLabel = new Label("Vestiaire: " + terrain.getVestiaire());
            Label statusLabel = new Label("Status: " + terrain.getStatus());
            Label prixLabel = new Label("Prix: " + terrain.getPrix());
            Label dureeLabel = new Label("Durée: " + terrain.getDuree());

            nomLabel.getStyleClass().add("label-style");
            addressLabel.getStyleClass().add("label-style");
            vestiaireLabel.getStyleClass().add("label-style");
            prixLabel.getStyleClass().add("label-style");
            dureeLabel.getStyleClass().add("label-style");
            gradinLabel.getStyleClass().add("label-style");

            Button btnReserver = new Button("Réserver");
            btnReserver.getStyleClass().add("reserver-button");

            btnReserver.setOnAction(event -> {
                // Code à exécuter lorsqu'on clique sur le bouton "Réserver"

                try {
                    ajouterReservationTerrain(terrain.getId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Réserver terrain avec l'ID: " + terrain.getId());
            });

            hBox.getChildren().addAll(nomLabel,addressLabel,gradinLabel,vestiaireLabel,dureeLabel,prixLabel,btnReserver);
            anchorPane3.getChildren().addAll(hBox);
            Vbox1.getChildren().add(anchorPane3);

        }
    }


    public void ajouterReservationTerrain(int idTerrain ) throws SQLException {

        if(verfierHeure(heure.getText()) && verfierDate(datepicker)){
            String date = convertirDateEnString(datepicker);
            Reservation r1 = new Reservation(false,date,heure.getText(),ReserverTerrainPourEquipe ,idTerrain);
            ReservationService reservationService = new ReservationService();
            reservationService.ajouterReservation(r1);
            PaimentController paimentController = new PaimentController();
            paimentController.
        }
    }
    public boolean verfierHeure(String horaire) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime heure = LocalTime.parse(horaire, formatter);
             if(heure.isAfter(LocalTime.of(7, 59)) && heure.isBefore(LocalTime.of(23, 1))){
                 return true ;
             }else {
                    horaireInvalides.setVisible(true);
                    return false;
             }
        } catch (Exception e) {

            return false;
        }
    }
    public boolean verfierDate(DatePicker datepicker){
        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateSelectionnee = datepicker.getValue();
        if(dateSelectionnee != null && dateSelectionnee.isAfter(dateActuelle)){
            return true ;
        }else {
            dateInvalide.setVisible(true);
        return false;}
    }

    public String convertirDateEnString(DatePicker datepicker){
        LocalDate dateSelectionnee = datepicker.getValue(); ;
        if (dateSelectionnee != null) {
            return dateSelectionnee.toString();
        } else {
            return null;
        }
    }
}

