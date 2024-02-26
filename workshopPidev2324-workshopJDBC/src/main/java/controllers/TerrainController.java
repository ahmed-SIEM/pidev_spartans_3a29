package controllers;

import entity.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.TerrainService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
//*******************************************************************************************
public class TerrainController {

    public AnchorPane anchorpane;
    @FXML
    private Button btannuler;
    @FXML
    private Button btinserer;
    @FXML
    private Button btninserervid;
    @FXML
    private Button btnsave;
    @FXML
    private Button btvoir;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfaddress;
    @FXML
    private CheckBox cbGradin;
    @FXML
    private CheckBox cbVestiaire;
    @FXML
    private CheckBox cbStatus;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfduree;
    @FXML
    private TextField tfemplacement;
    @FXML
    private ImageView img;
    @FXML
    private MediaView vid;
    @FXML
    private VBox terrainContainer;
    //*******************************************************************************************
    private String imagePath;
    private String videoPath;
    private TerrainService ts = new TerrainService();
    private List<Terrain> pageTerrain;
    private Terrain terrainActuel;
    //*******************************************************************************************
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTerrains();
        cbGradin.setSelected(false);
        cbVestiaire.setSelected(false);
        cbStatus.setSelected(false);
        pageTerrain = new ArrayList<>();}
    //*******************************************************************************************
    private void showTerrains() {
        List<Terrain> terrains = ts.getAllTerrains();
        for (Terrain terrain : terrains) {
            HBox terrainBox = new HBox();
            terrainBox.setSpacing(10);
            Label nomLabel = new Label("Nom: " + terrain.getNomTerrain());
            Label addressLabel = new Label("Address: " + terrain.getAddress());
            Label gradinLabel = new Label("Gradin: " + terrain.getGradin());
            Label vestiaireLabel = new Label("Vestiaire: " + terrain.getVestiaire());
            Label statusLabel = new Label("Status: " + terrain.getStatus());
            Label prixLabel = new Label("Prix: " + terrain.getPrix());
            Label dureeLabel = new Label("Durée: " + terrain.getDuree());
            Label gouvernoratLabel = new Label("Gouvernorat: " + terrain.getGouvernorat());
            ImageView imageView = new ImageView(new Image(terrain.getImage()));
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            Media media = null;
            MediaPlayer mediaPlayer = null;
            if (terrain.getVideo() != null && !terrain.getVideo().isEmpty()) {
                media = new Media(terrain.getVideo());
                mediaPlayer = new MediaPlayer(media);}
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(50);
            mediaView.setFitHeight(50);}}
    //*******************************************************************************************
    @FXML
    void clearField() {
        tfnom.setText("");
        tfaddress.setText("");
        cbGradin.setSelected(false);
        cbVestiaire.setSelected(false);
        cbStatus.setSelected(false);
        tfprix.setText("");
        tfduree.setText("");
        tfemplacement.setText("");
        img.setImage(null);
        vid.setMediaPlayer(null);
        imagePath = null;
        videoPath = null;}
    //*******************************************************************************************
    @FXML
    void createTerrain(ActionEvent event) throws SQLException, IOException {
        if (videoPath == null) {
            videoPath = "";
        }
        if (isValidTerrain()) {
            Terrain terrain = new Terrain(tfaddress.getText(), cbGradin.isSelected(), cbVestiaire.isSelected(), cbStatus.isSelected(), tfnom.getText(), Integer.parseInt(tfprix.getText()), Integer.parseInt(tfduree.getText()), tfemplacement.getText(), imagePath, videoPath);
            ts.add(terrain);
            showTerrains(); // Mettre à jour l'affichage après avoir ajouté un nouveau terrain
            clearField(); // Efface les champs après l'ajout
            ((Button) event.getSource()).getScene().getWindow().hide();
            voirlist(new ActionEvent());
        }}
    //*******************************************************************************************
    private boolean isValidTerrain() {
        if (tfnom.getText().isEmpty() || tfaddress.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur de saisie", "Veuillez remplir tous les champs obligatoires.");
            return false;}
        try {
            int prix = Integer.parseInt(tfprix.getText());
            int duree = Integer.parseInt(tfduree.getText());
            if (prix <= 0 || duree <= 0) {
                showAlert(Alert.AlertType.ERROR, "Erreur de saisie", "Le prix et la durée doivent être supérieurs à zéro.");
                return false;}
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de saisie", "Le prix et la durée doivent être des nombres entiers.");
            return false;}
        return true;}
    //*******************************************************************************************
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();}
    //*******************************************************************************************
    @FXML
    void updateTerrain(ActionEvent event) {
        if (isValidTerrain()) {
            terrainActuel.setNomTerrain(tfnom.getText());
            terrainActuel.setAddress(tfaddress.getText());
            terrainActuel.setGradin(cbGradin.isSelected());
            terrainActuel.setVestiaire(cbVestiaire.isSelected());
            terrainActuel.setStatus(cbStatus.isSelected());
            terrainActuel.setPrix(Integer.parseInt(tfprix.getText()));
            terrainActuel.setDuree(Integer.parseInt(tfduree.getText()));
            terrainActuel.setGouvernorat(tfemplacement.getText());
            terrainActuel.setImage(imagePath);
            terrainActuel.setVideo(videoPath);
            TerrainService terrainService = new TerrainService();
            terrainService.update(terrainActuel);
            // Mise à jour de la liste des terrains affichés
            showTerrains();
            clearField();}}
    //*******************************************************************************************
    @FXML
    void getData(MouseEvent event) {
        Node source = (Node) event.getSource();
        HBox terrainBox = (HBox) source.getParent();
        Terrain terrain = (Terrain) terrainBox.getUserData();
        if (terrain != null) {
            tfnom.setText(terrain.getNomTerrain());
            tfaddress.setText(terrain.getAddress());
            cbGradin.setSelected(terrain.getGradin());
            cbVestiaire.setSelected(terrain.getVestiaire());
            cbStatus.setSelected(terrain.getStatus());
            tfprix.setText(String.valueOf(terrain.getPrix()));
            tfduree.setText(String.valueOf(terrain.getDuree()));
            tfemplacement.setText(terrain.getGouvernorat());

            String imagePath = terrain.getImage();
            if (imagePath != null && !imagePath.isEmpty()) {
                Image image = new Image(imagePath);
                img.setImage(image);
            } else {
                img.setImage(null);}

            String videoPath = terrain.getVideo();
            if (videoPath != null && !videoPath.isEmpty()) {
                Media media = new Media(videoPath);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                vid.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            } else {
                vid.setMediaPlayer(null);}}}
    //*******************************************************************************************
    @FXML
    void addTerrain_imageview(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers image", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            img.setImage(image);}}
    //*******************************************************************************************
    @FXML
    void addvid(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une vidéo");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers vidéo", "*.mp4", "*.flv", "*.avi"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            videoPath = selectedFile.toURI().toString();
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            vid.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();}}
    //*******************************************************************************************
   @FXML
    void voirlist(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PageTerrain.fxml"));
       Parent root = loader.load();
       Stage stage = new Stage();
       stage.setTitle("Gestion_Terrain");
       stage.setScene(new Scene(root));
       stage.show();
       ((Button) event.getSource()).getScene().getWindow().hide();}
    //*******************************************************************************************
    @FXML
    void showTerrainDetails(Terrain terrain) {
        tfnom.setText(terrain.getNomTerrain());
        tfaddress.setText(terrain.getAddress());
        cbGradin.setSelected(terrain.getGradin());
        cbVestiaire.setSelected(terrain.getVestiaire());
        cbStatus.setSelected(terrain.getStatus());
        tfprix.setText(String.valueOf(terrain.getPrix()));
        tfduree.setText(String.valueOf(terrain.getDuree()));
        tfemplacement.setText(terrain.getGouvernorat());}
    //*******************************************************************************************
    public void initData(Terrain terrain) {
        this.terrainActuel = terrain;
        tfnom.setText(terrain.getNomTerrain());
        tfaddress.setText(terrain.getAddress());
        cbGradin.setSelected(terrain.getGradin());
        cbVestiaire.setSelected(terrain.getVestiaire());
        cbStatus.setSelected(terrain.getStatus());
        tfprix.setText(String.valueOf(terrain.getPrix()));
        tfduree.setText(String.valueOf(terrain.getDuree()));
        tfemplacement.setText(terrain.getGouvernorat());
        imagePath = terrain.getImage();
        videoPath = terrain.getVideo();
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(imagePath);
            img.setImage(image);}
        if (videoPath != null && !videoPath.isEmpty()) {
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            vid.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();}}}