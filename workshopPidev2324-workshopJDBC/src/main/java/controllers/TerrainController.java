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
import services.TerrainService;
import utils.MyDatabase;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TerrainController  {
    Connection connection ;
    PreparedStatement t;
    ResultSet rs;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnupdate;

    @FXML
    private TextField tfaddress;

        @FXML
        private TextField tfnom;
        
        @FXML
        private TextField tfgradin;

        @FXML
        private TextField tfprix;

    @FXML
    private TextField tfstatus;
    @FXML
    private TextField tfvestiaire;

     @FXML
     private TextField tfduree;

    @FXML
    private TableColumn<Terrain, String> caddress;

    @FXML
    private TableColumn<Terrain, String> cgradin;

    @FXML
    private TableColumn<Terrain, String> cstatus;

    @FXML
    private TableColumn<Terrain, Integer> cvestiaire;

    @FXML
    private TableColumn<Terrain, Integer> idc;

    @FXML
    private TableColumn<Terrain,String> cnom;

    @FXML
    private TableColumn<Terrain,Integer> cprix;

    @FXML
    private TableColumn<Terrain,Integer> cduree;

    @FXML
    private TableView<Terrain> table;

private TerrainService ts=new TerrainService();
@FXML
public void Initialize(URL url, ResourceBundle resourceBundle ){showTerrains();}

    private void showTerrains() {
        ObservableList<Terrain> list = getTerrain();
        table.setItems(list);
        idc.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("id"));
        cnom.setCellValueFactory(new PropertyValueFactory<Terrain,String>("nomt"));
        caddress.setCellValueFactory(new PropertyValueFactory<Terrain,String>("address"));
        cgradin.setCellValueFactory(new PropertyValueFactory<Terrain,String>("gradin"));
        cvestiaire.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("vestiaire"));
        cstatus.setCellValueFactory(new PropertyValueFactory<Terrain,String>("status"));
        cprix.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("prix"));
        cduree.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("duree"));
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
                 terrains.add(t);}
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
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
        btnsave.setDisable(false);}

    @FXML
    void createTerrain(ActionEvent event) throws SQLException {
        Terrain terrain = new Terrain(tfaddress.getText(), tfgradin.getText(), Integer.parseInt(tfvestiaire.getText()), tfstatus.getText(), tfnom.getText(), Integer.parseInt(tfprix.getText()), Integer.parseInt(tfduree.getText()));
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
            System.out.println("ereeuuuuuuuuuur");
        }}

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

            ts.update(terrain); // Appel de la méthode update du TerrainService
            showTerrains(); // Rafraîchit la TableView
        }else {
            // Afficher un message d'erreur car aucun terrain n'est sélectionné
            System.out.println("ereeuuuuuuuuuur");
        }}

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
            btnsave.setDisable(false);
        }
    @FXML
    void getData(MouseEvent event) {getData();}
    @FXML
    void showTerrain(ActionEvent event) {showTerrains();}
}


