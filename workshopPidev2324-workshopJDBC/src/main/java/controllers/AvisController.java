package controllers;

import entity.AvisTerrain;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.AvisService;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AvisController {
    @FXML
    private Button btannuler;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnupdate;
    @FXML
    private TextField tfID_avis;
    @FXML
    private TextField tfcommentaire;
    @FXML
    private TextField tfnote;
    @FXML
    private DatePicker datePicker;
    @FXML
    private VBox AvisContainer;

    private AvisService as = new AvisService();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTerrains();
    }

    private void showTerrains() {
        AvisContainer.getChildren().clear();
        ObservableList<AvisTerrain> terrains = as.getAllTerrains();
        for (AvisTerrain avis : terrains) {
            HBox terrainBox = new HBox();
            terrainBox.setSpacing(10);
            Label id_avisLabel = new Label("idAvis: " + avis.getIdAvis());
            Label commentairelabel = new Label("commentaire: " + avis.getCommentaire());
            Label notelabel = new Label("note: " + avis.getNote());
            Label datelabel = new Label("date_avis: " + avis.getDate_avis());
            terrainBox.getChildren().addAll(id_avisLabel, new Label("|"), commentairelabel, new Label("|"), notelabel, new Label("|"), datelabel);
            AvisContainer.getChildren().add(terrainBox);
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();} 

    @FXML
    void Annuler() {
        tfID_avis.setText("");
        tfcommentaire.setText("");
        tfnote.setText("");
        datePicker.setValue(null);
    }

    @FXML
    void annuleravis(ActionEvent event) {
        Annuler();
    }

    @FXML
    void ajouterAvis(ActionEvent event) throws SQLException {
        // Récupérer la note saisie
        int note = Integer.parseInt(tfnote.getText());

        // Vérifier si la note est comprise entre 0 et 5
        if (note < 0 || note > 5) {
            showAlert(Alert.AlertType.ERROR, "Erreur de saisie", "La note doit être comprise entre 0 et 5.");
            return;
        }
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
        AvisTerrain terrain = new AvisTerrain(tfcommentaire.getText(), Integer.parseInt(tfnote.getText()), date);
        as.add(terrain);
        showTerrains();
        Annuler();
    }

    @FXML
    void SupprimerAvis(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(tfID_avis.getText());
        AvisTerrain terrain = as.getTerrainById(id);
        if (terrain != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer cet avis ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                as.delete(id);
                showTerrains();
            }
        }
    }

    @FXML
    void modifierAvis(ActionEvent event) throws SQLException {
        int id = Integer.parseInt(tfID_avis.getText());
        AvisTerrain terrain = as.getTerrainById(id);
        if (terrain != null) {
            if (!tfcommentaire.getText().isEmpty()) {
                terrain.setCommentaire(tfcommentaire.getText());
            }
            if (!tfnote.getText().isEmpty()) {
                terrain.setNote(Integer.parseInt(tfnote.getText()));
            }
            if (datePicker.getValue() != null) {
                terrain.setDate_avis(datePicker.getValue().toString());
            }
            // Mettre à jour le terrain dans la base de données
            as.update(terrain);
            // Mettre à jour l'affichage des terrains
            showTerrains();
        }
    }


    @FXML
    void getData(MouseEvent event) {
        Node source = (Node) event.getSource();
        HBox terrainBox = (HBox) source.getParent();
        AvisTerrain terrain = (AvisTerrain) terrainBox.getUserData();
        if (terrain != null) {
            tfID_avis.setText(String.valueOf(terrain.getIdAvis()));
            tfcommentaire.setText(terrain.getCommentaire());
            tfnote.setText(String.valueOf(terrain.getNote()));
            datePicker.setValue(terrain.getDate_avis() != null ? LocalDate.parse(terrain.getDate_avis()) : null);
        }
    }
}