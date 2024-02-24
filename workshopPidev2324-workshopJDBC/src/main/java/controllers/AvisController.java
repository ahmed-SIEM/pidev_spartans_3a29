package controllers;
import entity.AvisTerrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import services.AvisService;
import services.TerrainService;
import utils.MyDatabase;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AvisController  {
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
    private TableColumn<AvisTerrain, Integer> idc;

    @FXML
    private TableColumn<AvisTerrain,String> cnom;

    @FXML
    private TableColumn<AvisTerrain, String> caddress;

    @FXML
    private TableColumn<AvisTerrain, String> cgradin;

    @FXML
    private TableColumn<AvisTerrain, Integer> cvestiaire;

    @FXML
    private TableColumn<AvisTerrain, String> cstatus;

    @FXML
    private TableColumn<AvisTerrain,Integer> cprix;

    @FXML
    private TableColumn<AvisTerrain,Integer> cduree;

    @FXML
    private TableView<AvisTerrain> table;

    private AvisService at=new AvisService();
    @FXML
    public void Initialize(URL url, ResourceBundle resourceBundle ){showTerrains();}
    private void showTerrains() {
        ObservableList<AvisTerrain> list = getTerrain();
        table.setItems(list);
        idc.setCellValueFactory(new PropertyValueFactory<AvisTerrain,Integer>("id"));
        cnom.setCellValueFactory(new PropertyValueFactory<AvisTerrain,String>("nomt"));
        caddress.setCellValueFactory(new PropertyValueFactory<AvisTerrain,String>("address"));
        cgradin.setCellValueFactory(new PropertyValueFactory<AvisTerrain,String>("gradin"));
        cvestiaire.setCellValueFactory(new PropertyValueFactory<AvisTerrain,Integer>("vestiaire"));
        cstatus.setCellValueFactory(new PropertyValueFactory<AvisTerrain,String>("status"));
        cprix.setCellValueFactory(new PropertyValueFactory<AvisTerrain,Integer>("prix"));
        cduree.setCellValueFactory(new PropertyValueFactory<AvisTerrain,Integer>("duree"));}
    public ObservableList<AvisTerrain> getTerrain(){
        ObservableList<AvisTerrain> terrains = FXCollections.observableArrayList();
        String query = "select* from terrain";
        connection = MyDatabase.getInstance().getConnection();
        try {
            t = connection.prepareStatement(query);
            rs = t.executeQuery();
            while (rs.next()){
                AvisTerrain t = new AvisTerrain();
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
        btnsave.setDisable(false);}
    @FXML
    void createTerrain(ActionEvent event) throws SQLException {
        AvisTerrain terrain = new AvisTerrain(tfaddress.getText(), tfgradin.getText(), Integer.parseInt(tfvestiaire.getText()), tfstatus.getText(), tfnom.getText(), Integer.parseInt(tfprix.getText()), Integer.parseInt(tfduree.getText()));
        at.add(terrain);
        showTerrains();
        clearField(); //Efface les champs après l'ajout
    }
    @FXML
    void deleteTerrain(ActionEvent event) throws SQLException {

        AvisTerrain terrain = table.getSelectionModel().getSelectedItem(); // Récupère le terrain sélectionné dans la TableView
        if (terrain != null) {
            at.delete(terrain.getId()); // Appel de la méthode delete du TerrainService avec l'ID du terrain sélectionné
            showTerrains(); // Rafraîchit la TableView
        } else {
            // Afficher un message d'erreur car aucun terrain n'est sélectionné
            System.out.println("erreeuuuuuuuuuur");}}
    @FXML
    void updateTerrain(ActionEvent event) throws SQLException {

        AvisTerrain terrain = table.getSelectionModel().getSelectedItem(); // Récupère le terrain sélectionné dans la TableView
        if (terrain != null) {
            terrain.setAddress(tfaddress.getText());
            terrain.setGradin(tfgradin.getText());
            terrain.setVestiaire(Integer.parseInt(tfvestiaire.getText()));
            terrain.setStatus(tfstatus.getText());
            terrain.setNomt(tfnom.getText());
            terrain.setPrix(Integer.parseInt(tfprix.getText()));
            terrain.setDuree(Integer.parseInt(tfduree.getText()));

            at.update(terrain); // Appel de la méthode update du TerrainService
            showTerrains(); // Rafraîchit la TableView
        }else {
            // Afficher un message d'erreur car aucun terrain n'est sélectionné
            System.out.println("erreeuuuuuuuuuur");}}
    @FXML
    public void getData() {
        AvisTerrain terrain = table.getSelectionModel().getSelectedItem();
        tfaddress.setText(terrain.getAddress());
        tfgradin.setText(terrain.getGradin());
        tfvestiaire.setText(String.valueOf(terrain.getVestiaire()));
        tfstatus.setText(terrain.getStatus());
        tfnom.setText(terrain.getNomt());
        tfprix.setText(String.valueOf(terrain.getPrix()));
        tfduree.setText(String.valueOf(terrain.getDuree()));
        btnsave.setDisable(false);}
    @FXML
    void getData(MouseEvent event) {getData();}
    @FXML
    void showTerrain(ActionEvent event) {showTerrains();}
}


