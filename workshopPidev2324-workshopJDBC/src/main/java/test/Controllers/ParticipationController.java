package test.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Participation;
import models.Tournoi;
import services.GestionEvenement.ServiceParticipation;
import test.MainFx;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ParticipationController {
    @FXML
    private Button Btnback;

    @FXML
    private Button btparticiper;

    @FXML
    private AnchorPane detailroot;

    @FXML
    private Label nomd;

    @FXML
    private ComboBox<String> nomequipe;

    private Tournoi tournoiActuel;



    @FXML
    void goToDetailsClient(ActionEvent event) throws IOException {
        System.out.println(tournoiActuel);
        FXMLLoader loader = new FXMLLoader(MainFx.class.getResource("DetailClient.fxml"));
        DetailClientController controller = loader.getController();
        controller.initData(tournoiActuel);
        AnchorPane root = loader.load();
        detailroot.getChildren().setAll(root);
    }

    public void initData(Tournoi tournoi) {
        this.tournoiActuel = tournoi;

        }


    @FXML
    void equipe(ActionEvent event)  throws SQLException {
        ServiceParticipation ps = new ServiceParticipation();
        int idMembre = 3;

        try {
            List<String> nomsEquipes = ps.getNomsEquipesPourMembre(idMembre);
            ObservableList<String> options = FXCollections.observableArrayList(nomsEquipes);
            nomequipe.setItems(options);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void participerd(ActionEvent event) throws SQLException, IOException {
        ServiceParticipation ps = new ServiceParticipation();
        String nomEquipeSelectionne = nomequipe.getValue();
        int idTournoi = tournoiActuel.getId();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de participation");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir participez dans ce tournoi ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Participation nouvelleParticipation = new Participation(3, nomEquipeSelectionne, idTournoi);
            ps.ajouter(nouvelleParticipation);
            System.out.println(nouvelleParticipation);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/test/tournoiClient.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Gestion_Tournoi");
            stage.setScene(new Scene(root));
            stage.show();
            ((Button) event.getSource()).getScene().getWindow().hide();}
     else {showAlert(Alert.AlertType.ERROR, "Erreur de participation", "L'index de tournoi à participer n'est pas valide.");}
}
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();}



}
