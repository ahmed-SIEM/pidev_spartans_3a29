package controllers;

import entity.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import services.TerrainService;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TerrainController {
    @FXML
    private Button btannuler;
    @FXML
    private Button btinserer;
    @FXML
    private Button btndelete;
    @FXML
    private Button btninserervid;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnupdate;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfaddress;
    @FXML
    private TextField tfgradin;
    @FXML
    private TextField tfvestiaire;
    @FXML
    private TextField tfstatus;
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
    private String imagePath;
    private String videoPath;
    private TerrainService ts = new TerrainService();
    @FXML
    private VBox terrainContainer;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTerrains();
    }

    private void showTerrains() {
        terrainContainer.getChildren().clear();
        ObservableList<Terrain> terrains = ts.getAllTerrains();
        for (Terrain terrain : terrains) {
            HBox terrainBox = new HBox();
            terrainBox.setSpacing(10);
            Label idLabel = new Label("Id: " + terrain.getId());
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
            Media media = new Media(terrain.getVideo());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(50);
            mediaView.setFitHeight(50);

            terrainBox.getChildren().addAll(idLabel,nomLabel, addressLabel, gradinLabel, vestiaireLabel, statusLabel, prixLabel, dureeLabel, gouvernoratLabel, imageView, mediaView);
            terrainContainer.getChildren().add(terrainBox);}}
    @FXML
    void clearField() {
        tfnom.setText("");
        tfaddress.setText("");
        tfgradin.setText("");
        tfvestiaire.setText("");
        tfstatus.setText("");
        tfprix.setText("");
        tfduree.setText("");
        tfemplacement.setText("");
        img.setImage(null);
        vid.setMediaPlayer(null);
        imagePath = null;
        videoPath = null;}
    @FXML
    void createTerrain(ActionEvent event) throws SQLException {
        if (videoPath == null) {
            videoPath = "";
        }
        Terrain terrain = new Terrain(tfaddress.getText(), Boolean.parseBoolean(tfgradin.getText()), Boolean.parseBoolean(tfvestiaire.getText()), Boolean.parseBoolean(tfstatus.getText()), tfnom.getText(), Integer.parseInt(tfprix.getText()), Integer.parseInt(tfduree.getText()), tfemplacement.getText(), imagePath, videoPath);
        ts.add(terrain);
        showTerrains(); // Mettre à jour l'affichage après avoir ajouté un nouveau terrain
        clearField(); // Efface les champs après l'ajout
    }


    @FXML
    void deleteTerrain(ActionEvent event) throws SQLException {
        String nom = tfnom.getText();
        Terrain terrain = ts.getTerrainByNom(nom);
        if (terrain != null) {
            ts.delete(terrain.getId());
            showTerrains();
        } else {
            System.out.println("Terrain non trouvé.");
        }
    }

    @FXML
    void updateTerrain(ActionEvent event) throws SQLException {
        Node source = (Node) event.getSource();
        HBox terrainBox = (HBox) source.getParent();
        Terrain terrain = (Terrain) terrainBox.getUserData();
        if (terrain != null) {
            if (!tfaddress.getText().isEmpty()) {
                terrain.setAddress(tfaddress.getText());
            }
            if (!tfgradin.getText().isEmpty()) {
                terrain.setGradin(Boolean.parseBoolean(tfgradin.getText()));
            }
            if (!tfvestiaire.getText().isEmpty()) {
                terrain.setVestiaire(Boolean.parseBoolean(tfvestiaire.getText()));
            }
            if (!tfstatus.getText().isEmpty()) {
                terrain.setStatus(Boolean.parseBoolean(tfstatus.getText()));
            }
            if (!tfprix.getText().isEmpty()) {
                terrain.setPrix(Integer.parseInt(tfprix.getText()));
            }
            if (!tfduree.getText().isEmpty()) {
                terrain.setDuree(Integer.parseInt(tfduree.getText()));
            }
            if (!tfemplacement.getText().isEmpty()) {
                terrain.setGouvernorat(tfemplacement.getText());
            }
            if (imagePath != null) {
                terrain.setImage(imagePath);
            }
            if (videoPath != null) {
                terrain.setVideo(videoPath);
            }

            ts.update(terrain);
            showTerrains();
        } else {
            System.out.println("Terrain non trouvé.");
        }
    }


    @FXML
    void getData(MouseEvent event) {
        Node source = (Node) event.getSource();
        HBox terrainBox = (HBox) source.getParent();
        Terrain terrain = (Terrain) terrainBox.getUserData();
        tfaddress.setText(terrain.getAddress());
        tfgradin.setText(String.valueOf(terrain.getGradin()));
        tfvestiaire.setText(String.valueOf(terrain.getVestiaire()));
        tfstatus.setText(String.valueOf(terrain.getStatus()));
        tfnom.setText(terrain.getNomTerrain());
        tfprix.setText(String.valueOf(terrain.getPrix()));
        tfduree.setText(String.valueOf(terrain.getDuree()));
        tfemplacement.setText(terrain.getGouvernorat());

        // Affichage de l'image
        String imagePath = terrain.getImage();
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(imagePath);
            img.setImage(image);
        } else {
            img.setImage(null); // Efface l'image s'il n'y en a pas
        }

        // Affichage de la vidéo
        String videoPath = terrain.getVideo();
        if (videoPath != null && !videoPath.isEmpty()) {
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            vid.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        } else {
            vid.setMediaPlayer(null); // Efface la vidéo s'il n'y en a pas
        }
    }


    @FXML
    void addTerrain_imageview(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers image", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            img.setImage(image);
        }}
    @FXML
    void addvid(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une vidéo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Fichiers vidéo", "*.mp4", "*.flv", "*.avi")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            videoPath = selectedFile.toURI().toString();
            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            vid.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
    }
    @FXML
    void getDataByNom(String nom) {
        Terrain terrain = ts.getTerrainByNom(nom);
        if (terrain != null) {
            tfaddress.setText(terrain.getAddress());
            tfgradin.setText(String.valueOf(terrain.getGradin()));
            tfvestiaire.setText(String.valueOf(terrain.getVestiaire()));
            tfstatus.setText(String.valueOf(terrain.getStatus()));
            tfnom.setText(terrain.getNomTerrain());
            tfprix.setText(String.valueOf(terrain.getPrix()));
            tfduree.setText(String.valueOf(terrain.getDuree()));
            tfemplacement.setText(terrain.getGouvernorat());
            imagePath = terrain.getImage();
            if (imagePath != null && !imagePath.isEmpty()) {
                Image image = new Image(imagePath);
                img.setImage(image);
            }
            videoPath = terrain.getVideo();
            if (videoPath != null && !videoPath.isEmpty()) {
                Media media = new Media(videoPath);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                vid.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }
        }
    }


}