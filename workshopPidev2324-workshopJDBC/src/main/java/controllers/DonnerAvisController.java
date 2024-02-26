package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.AvisService;
import javafx.scene.image.Image;
//*******************************************************************************************
public class DonnerAvisController {
    @FXML
    private VBox terrainBox;
    @FXML
    private ImageView terrainImage;
    @FXML
    private Label terrainName;
    @FXML
    private TextArea commentArea;
    @FXML
    private Slider noteSlider;
    //*******************************************************************************************
    private int terrainId;
    private AvisService avisService;
    //*******************************************************************************************
    public void initialize() {
        avisService = new AvisService();
    }
//*******************************************************************************************
    public void setTerrain(String terrainName, String terrainImagePath, int terrainId) {
        this.terrainName.setText(terrainName);
        this.terrainId = terrainId;
        try {
            // Charger l'image du terrain à partir de terrainImagePath dans terrainImage
            Image image = new Image(terrainImagePath);
            terrainImage.setImage(image);
        } catch (Exception e) {
            // Gérer l'erreur si le chargement de l'image échoue
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());}}
    //*******************************************************************************************
    @FXML
    public void submitAvis() {
        // Récupérer le commentaire et la note depuis commentArea et noteSlider
        String commentaire = commentArea.getText();
        int note = (int) noteSlider.getValue();

        // Envoyer le commentaire et la note au service pour l'ajout dans la base de données
        try {
            avisService.addAvis(terrainId, commentaire, note);
            showAlert(Alert.AlertType.INFORMATION, "Avis ajouté", "Votre avis a été ajouté avec succès.");
            // Fermer la fenêtre de donner avis
            Stage stage = (Stage) terrainBox.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Une erreur est survenue lors de l'ajout de l'avis.");}}
    //*******************************************************************************************
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();}}