package controllers;

import entity.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;

public class DetailTerrainController {
    @FXML
    private Label addressd;

    @FXML
    private Button btmodifd;

    @FXML
    private Button btmodifimgd;

    @FXML
    private MediaView detvid;

    @FXML
    private Label dureed;

    @FXML
    private Label gouvd;

    @FXML
    private Label gradind;

    @FXML
    private ImageView imgd;

    @FXML
    private Label nomd;

    @FXML
    private Label prixd;

    @FXML
    private Label statd;

    @FXML
    private Label vestd;

    public void initData(Terrain terrain) {
        nomd.setText(terrain.getNomTerrain());
        gouvd.setText(terrain.getGouvernorat());
        dureed.setText(String.valueOf(terrain.getDuree()));
        prixd.setText(String.valueOf(terrain.getPrix()));
        addressd.setText(terrain.getAddress());
        gradind.setText(String.valueOf(terrain.getGradin()));
        vestd.setText(String.valueOf(terrain.getVestiaire()));
        statd.setText(String.valueOf(terrain.getStatus()));

        // Affichage de l'image
        if (terrain.getImage() != null && !terrain.getImage().isEmpty()) {
            Image image = new Image(terrain.getImage());
            imgd.setImage(image);
        }

        // Affichage de la vidéo
        if (terrain.getVideo() != null && !terrain.getVideo().isEmpty()) {
            Media media = new Media(terrain.getVideo());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            detvid.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
    }

    @FXML
    void modifd(ActionEvent event) {
        // Code de modification de terrain
    }

    @FXML
    void modifimgd(ActionEvent event) {
        // Code de modification d'image
    }
}

