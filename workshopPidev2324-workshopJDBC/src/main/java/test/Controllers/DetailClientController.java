package test.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Participation;
import models.Tournoi;
import services.GestionEvenement.ServiceParticipation;
import services.GestionEvenement.ServiceTournoi;
import test.MainFx;

import java.io.IOException;
import java.sql.SQLException;

public class DetailClientController {
    @FXML
    private Button Btnback;

    @FXML
    private Label adresse;

    @FXML
    private Button btparticiper;

    @FXML
    private AnchorPane detailroot;

    @FXML
    private ImageView imgd;

    @FXML
    private Label nombre;

    @FXML
    private Label nomd;
    private Tournoi tournoiActuel;

    @FXML
    public void goToTournoiClient(ActionEvent actionEvent) throws IOException {


        FXMLLoader loader = new FXMLLoader(MainFx.class.getResource("tournoiClient.fxml"));
        AnchorPane root = loader.load();
        detailroot.getChildren().setAll(root);
    }

    public void initData(Tournoi tournoi) {
        this.tournoiActuel = tournoi;
        System.out.println(tournoiActuel);
        nombre.setText(String.valueOf(tournoi.getNbrquipeMax()));
        nomd.setText(tournoi.getNom());
        adresse.setText(tournoi.getAddress());
        /*inputDateFin.setText(tournoi.getDatefin());
        InputAddress.setText(tournoi.getAddress());*/
        if (tournoi.getAffiche() != null && !tournoi.getAffiche().isEmpty()) {
            Image image = new Image(tournoi.getAffiche());
            imgd.setImage(image);}

    }

    @FXML
    void participerd(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(MainFx.class.getResource("Participation.fxml"));
        AnchorPane root = loader.load();
        ParticipationController controller = loader.getController();
        controller.initData(tournoiActuel);
        detailroot.getChildren().setAll(root);

    }

}


