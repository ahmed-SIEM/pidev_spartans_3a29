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
import models.Terrain;
import services.TerrainService;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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


    public void initialize(URL location, ResourceBundle resources) {
        showTerrains();
    }

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
            hBox.getChildren().addAll(nomLabel,addressLabel,gradinLabel,vestiaireLabel,dureeLabel,prixLabel);
            anchorPane3.getChildren().addAll(hBox);
            Vbox1.getChildren().add(anchorPane3);

        }
    }
}

