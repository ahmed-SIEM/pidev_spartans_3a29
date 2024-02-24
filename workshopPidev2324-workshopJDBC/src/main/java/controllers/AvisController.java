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
    private TextField tfdate;


    private AvisService as = new AvisService();
    @FXML
    private VBox AvisContainer;

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
            terrainBox.getChildren().addAll(id_avisLabel, commentairelabel, notelabel, datelabel);
            AvisContainer.getChildren().add(terrainBox);
        }
    }

    @FXML
    void Annuler() {
        tfID_avis.setText("");
        tfcommentaire.setText("");
        tfnote.setText("");
        tfdate.setText("");
    }

    @FXML
    void annulerAvis(ActionEvent event) {
        Annuler();
    }

    @FXML
    void ajouterAvis(ActionEvent event) throws SQLException {
        AvisTerrain terrain = new AvisTerrain(tfcommentaire.getText(), Integer.parseInt(tfnote.getText()), tfdate.getText());
        as.add(terrain);
        showTerrains(); // Mettre à jour l'affichage après avoir ajouté un nouveau terrain
        Annuler(); // Efface les champs après l'ajout}
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
            if (!tfdate.getText().isEmpty()) {
                terrain.setDate_avis(tfdate.getText());
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
            tfdate.setText(terrain.getDate_avis());
        }
    }
}