package controllers;
import entity.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.TerrainService;
import utils.MyDatabase;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class TerrainController  {
    Connection connection ;
    PreparedStatement t;
    ResultSet rs;

    @FXML
    private Button btnsave;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btannuler;
    @FXML
    private Button btinsert;
    @FXML
    private Button btninserervid;
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
    private TextField tfduree;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfemplacement;
    @FXML
    private TableColumn<Terrain, Integer> idc;
    @FXML
    private TableColumn<Terrain,String> cnom;
    @FXML
    private TableColumn<Terrain, String> caddress;
    @FXML
    private TableColumn<Terrain, String> cgradin;
    @FXML
    private TableColumn<Terrain, Integer> cvestiaire;
    @FXML
    private TableColumn<Terrain, String> cstatus;
    @FXML
    private TableColumn<Terrain,Integer> cprix;
    @FXML
    private TableColumn<Terrain,Integer> cduree;
    @FXML
    private TableColumn<Terrain, String> cgouvernorat;
    @FXML
    private TableColumn<Terrain, String> cimg;
    @FXML
    private TableColumn<Terrain, String> cvid;
    @FXML
    private TableView<Terrain> table;
    @FXML
    private ImageView img;
    @FXML
    private MediaView vid;
    private String imagePath;
    private String videoPath;
    private TerrainService ts=new TerrainService();
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTerrains();
    }

    private void showTerrains() {
        ObservableList<Terrain> list = getTerrain();
        table.setItems(list);
        idc.setCellValueFactory(new PropertyValueFactory<Terrain, Integer>("id"));
        cnom.setCellValueFactory(new PropertyValueFactory<Terrain, String>("nomt"));
        caddress.setCellValueFactory(new PropertyValueFactory<Terrain, String>("address"));
        cgradin.setCellValueFactory(new PropertyValueFactory<Terrain, String>("gradin"));
        cvestiaire.setCellValueFactory(new PropertyValueFactory<Terrain, Integer>("vestiaire"));
        cstatus.setCellValueFactory(new PropertyValueFactory<Terrain, String>("status"));
        cprix.setCellValueFactory(new PropertyValueFactory<Terrain, Integer>("prix"));
        cduree.setCellValueFactory(new PropertyValueFactory<Terrain, Integer>("duree"));
        cgouvernorat.setCellValueFactory(new PropertyValueFactory<Terrain, String>("gouvernorat"));
        cimg.setCellValueFactory(new PropertyValueFactory<Terrain, String>("image"));
        cvid.setCellValueFactory(new PropertyValueFactory<Terrain, String>("video"));

    }
    public ObservableList<Terrain> getTerrain(){
        ObservableList<Terrain> terrains = FXCollections.observableArrayList();
        String query = "select* from terrain";
        connection = MyDatabase.getInstance().getConnection();
        try {
            t = connection.prepareStatement(query);
            rs = t.executeQuery();
            while (rs.next()){
                Terrain t = new Terrain();
                t.setId(rs.getInt("id"));
                t.setNomt(rs.getString("nom"));
                t.setAddress(rs.getString("address"));
                t.setGradin(rs.getString("gradin"));
                t.setVestiaire(rs.getInt("vestiaire"));
                t.setStatus(rs.getString("status"));
                t.setPrix(rs.getInt("prix"));
                t.setDuree(rs.getInt("duree"));
                t.setGouvernorat(rs.getString("gouvernorat"));
                t.setImage((rs.getString("image")));
                t.setVideo((rs.getString("video")));
                terrains.add(t);}
        }catch (SQLException e){
            throw  new RuntimeException(e);}
        return terrains;}
    @FXML
    void clearField() {
        tfnom.setText(null);
        tfaddress.setText(null);
        tfgradin.setText(null);
        tfvestiaire.setText(null);
        tfstatus.setText(null);
        tfduree.setText(null);
        tfprix.setText(null);
        tfemplacement.setText(null);
        img.setImage(null); // Efface l'image affichée
        imagePath = null; // Réinitialise le chemin de l'image
        vid.setMediaPlayer(null);
        videoPath = null;
        btnsave.setDisable(false);}
    @FXML
    void createTerrain(ActionEvent event) throws SQLException {
        if (videoPath == null) {
            videoPath = "";
        }
        Terrain terrain = new Terrain(tfaddress.getText(), tfgradin.getText(), Integer.parseInt(tfvestiaire.getText()), tfstatus.getText(), tfnom.getText(), Integer.parseInt(tfprix.getText()), Integer.parseInt(tfduree.getText()), tfemplacement.getText(), imagePath, videoPath);
        ts.add(terrain);
        showTerrains();
        clearField(); //Efface les champs après l'ajout
}
    @FXML
    void deleteTerrain(ActionEvent event) throws SQLException {

        Terrain terrain = table.getSelectionModel().getSelectedItem(); // Récupère le terrain sélectionné dans la TableView
        if (terrain != null) {
            ts.delete(terrain.getId()); // Appel de la méthode delete du TerrainService avec l'ID du terrain sélectionné
            showTerrains(); // Rafraîchit la TableView
        } else {
            // Afficher un message d'erreur car aucun terrain n'est sélectionné
            System.out.println("erreeuuuuuuuuuur");}}
    @FXML
    void updateTerrain(ActionEvent event) throws SQLException {

        Terrain terrain = table.getSelectionModel().getSelectedItem(); // Récupère le terrain sélectionné dans la TableView
        if (terrain != null) {
            terrain.setAddress(tfaddress.getText());
            terrain.setGradin(tfgradin.getText());
            terrain.setVestiaire(Integer.parseInt(tfvestiaire.getText()));
            terrain.setStatus(tfstatus.getText());
            terrain.setNomt(tfnom.getText());
            terrain.setPrix(Integer.parseInt(tfprix.getText()));
            terrain.setDuree(Integer.parseInt(tfduree.getText()));
            terrain.setGouvernorat(tfemplacement.getText());
            terrain.setImage(imagePath); // Met à jour le chemin de l'image
            terrain.setVideo(videoPath);
            ts.update(terrain); // Appel de la méthode update du TerrainService
            showTerrains(); // Rafraîchit la TableView
        } else {
            // Afficher un message d'erreur car aucun terrain n'est sélectionné
            System.out.println("erreeuuuuuuuuuur");}
    }
        @FXML
        public void getData() {
            Terrain terrain = table.getSelectionModel().getSelectedItem();
            tfaddress.setText(terrain.getAddress());
            tfgradin.setText(terrain.getGradin());
            tfvestiaire.setText(String.valueOf(terrain.getVestiaire()));
            tfstatus.setText(terrain.getStatus());
            tfnom.setText(terrain.getNomt());
            tfprix.setText(String.valueOf(terrain.getPrix()));
            tfduree.setText(String.valueOf(terrain.getDuree()));
            tfemplacement.setText(String.valueOf(terrain.getGouvernorat()));
            btnsave.setDisable(false);
            imagePath = terrain.getImage();
            if (imagePath != null && !imagePath.isEmpty()) {
                Image image = new Image(imagePath);
                img.setImage(image);
            }
            String videoPath = terrain.getVideo();
            if (videoPath != null && !videoPath.isEmpty()) {
                Media media = new Media(videoPath);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                vid.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }
        }

    @FXML
    void getData(MouseEvent event) {getData();}
    @FXML
    void showTerrain(ActionEvent event) {showTerrains();}
    @FXML
    void clearField(ActionEvent event) { clearField();}
    @FXML
    void addTerrain_imageview(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            img.setImage(image);
        }
}
    @FXML
    void addvid(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Video File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.flv", "*.avi")
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
}