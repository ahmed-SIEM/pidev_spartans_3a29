package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane ;
import javafx.stage.Stage;
import models.Equipe;
import models.Reservation;
import models.Terrain;
import services.EquipeService;
import services.ReservationService;
import services.TerrainService;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class chercherAdversaireController implements Initializable {

    @FXML
    private Label nomEquipeInvalide;

    @FXML
    private ScrollPane Vbox1;

    @FXML
    private Button buttonAccueil;

    @FXML
    private Button buttonActualites;

    @FXML
    private Button buttonEvenement;

    @FXML
    private Button buttonReservation;

    @FXML
    private ChoiceBox<String> nom_equipe;
    /*
                                    // montaaaaaaaaaaaasar a3tini id user

     */
    private int idUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nomEquipeInvalide.setVisible(false);
        String[] nom = nomEquipes();
        nom_equipe.getItems().addAll(nom);


    }

    public String[] nomEquipes() {
        EquipeService equipeService = new EquipeService();
        // *********************************************************************************************
        //                                                 monta heeeet numro hatit 7
        // *****************************************************************************************
        try {
            List<Equipe> equipeList = equipeService.getEquipesParMembre(8);
            String[] nomEquipe = new String[equipeList.size()];

            int index = 0;
            for (Equipe equipe : equipeList) {
                nomEquipe[index] = equipe.getNomEquipe();
                index++;
            }
            return nomEquipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void VoirReservation(ActionEvent actionEvent) throws SQLException {

        if (nom_equipe.getValue() == null) {
            nomEquipeInvalide.setVisible(true);
        } else {

            showReservation();
        }
    }

    public void showReservation() throws SQLException {

        //Vbox1.getChildren().clear();
        Vbox1.getStyleClass().add("vbox-spacing");
        ReservationService reservationService = new ReservationService();
        List<Reservation> reservationList = reservationService.getAllReservation();
        for (Reservation reservation : reservationList) {
            AnchorPane anchorPane3 = new AnchorPane();
            HBox hBox = new HBox();
            anchorPane3.getStyleClass().add("anchor-pane-style");
            Label idReservationLabel = new Label("Id: " + reservation.getIdReservation());
            Label nomEquipeLabel = new Label("Nom: " + reservation.getNomEquipe1());
            Label DateReservationLabel = new Label("Address: " + reservation.getDateReservation());
            Label heureReservationLabel = new Label("Gradin: " + reservation.getHeureReservation());

            nomEquipeLabel.getStyleClass().add("label-style");
            DateReservationLabel.getStyleClass().add("label-style");
            heureReservationLabel.getStyleClass().add("label-style");


            TerrainService terrainService = new TerrainService();
            Terrain terrain = terrainService.getTerrainById(reservation.getIdTerrain());

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

                try {
                    ReservationService reservationService1 = new ReservationService();
                    if (reservationService1.updateNomEquipe2(reservation.getIdReservation(), nom_equipe.getValue())) {

                        passerPaiement(reservation.getIdReservation(), idUser);
                    }
                    //id user a changer de montassar

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Réserver terrain avec l'ID: " + terrain.getId());
            });

        }
    }

    public void passerPaiement(int idReservation, int idUser) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Paiment.fxml"));
            Parent root = (Parent) loader.load();
            PaimentController paimentController = loader.getController();
            paimentController.SetIdReservation(idReservation);
            paimentController.SetIdUser(idUser);
            ;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}