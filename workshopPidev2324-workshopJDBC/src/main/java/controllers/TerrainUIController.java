package controllers;

import entity.Terrain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import utils.MyDatabase;
import utils.TerrainDAO;

import java.util.List;

public class TerrainUIController {
    @FXML
    private VBox ListContainer;

    public void initialize() {
        // Récupérer la liste des terrains depuis la base de données
        TerrainDAO terrainDAO = new TerrainDAO(MyDatabase.getInstance().getConnection());
        List<Terrain> terrains = terrainDAO.getAllTerrains();

        // Créer les boxes pour chaque terrain
        for (Terrain terrain : terrains) {
            HBox terrainBox = createTerrainBox(terrain);
            ListContainer.getChildren().add(terrainBox);
        }
    }

    private HBox createTerrainBox(Terrain terrain) {
        HBox terrainBox = new HBox();
        terrainBox.getStyleClass().add("terrain-box");

        // Nom du terrain au-dessus de l'image
        Text nameText = new Text(terrain.getNomTerrain());
        nameText.getStyleClass().add("terrain-name");
        terrainBox.getChildren().add(nameText);

        // Image du terrain en arrière-plan
        Image image = new Image(terrain.getImage());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Ajuster la taille de l'image selon vos besoins
        imageView.setPreserveRatio(true);
        terrainBox.getChildren().add(imageView);

        // Boutons "Réserver" et "Voir détail"
        Button reserveButton = new Button("Réserver");
        Button detailButton = new Button("Voir détail");
        terrainBox.getChildren().addAll(reserveButton, detailButton);

        return terrainBox;
    }

}