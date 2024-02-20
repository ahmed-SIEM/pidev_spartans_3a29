package controllers;

import com.mysql.cj.jdbc.JdbcConnection;
import com.sun.jdi.IntegerValue;
import entity.Terrain;
import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Button btnclear;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnshow;

    @FXML
    private TextField tfid;
    @FXML
    private TextField tfaddress;


        @FXML

        private TextField tfnom;
        
        @FXML

        private TextField tfgradin;
        @FXML

        private TextField tfprix;

       /* @FXML
    private TextField tfid; */

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
    private TableColumn<Terrain, String> cvestiaire;

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
    int id = 0;
private TerrainService ts=new TerrainService();




    public ObservableList<Terrain> getTerrain() {
        ObservableList<Terrain> terrains = FXCollections.observableArrayList();
        String query = "SELECT * FROM terrain";
        try (Connection connection = MyDatabase.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Terrain t = new Terrain();
                t.setId(rs.getInt("id"));
                t.setNomt(rs.getString("nom"));
                t.setAddress(rs.getString("address"));
                t.setGradin(rs.getString("gradin"));
                t.setVestiaire(rs.getString("vestiaire"));
                t.setStatus(rs.getString("status"));
                t.setPrix(rs.getInt("prix"));
                t.setDuree(rs.getInt("duree"));
                terrains.add(t);
            }
        } catch (SQLException e) {
            // Handle or log the exception
            e.printStackTrace();
        }
        return terrains;
    }

    private void showTerrains() {
        ObservableList<Terrain> list = getTerrain();
        table.setItems(list);
        idc.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("id"));
        cnom.setCellValueFactory(new PropertyValueFactory<Terrain,String>("nomt"));
        caddress.setCellValueFactory(new PropertyValueFactory<Terrain,String>("address"));
        cgradin.setCellValueFactory(new PropertyValueFactory<Terrain,String>("gradin"));
        cvestiaire.setCellValueFactory(new PropertyValueFactory<Terrain,String>("vestiaire"));
        cstatus.setCellValueFactory(new PropertyValueFactory<Terrain,String>("status"));
        cprix.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("prix"));
        cduree.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("duree"));

    }

    /*public ObservableList<Terrain> getTerrain(){
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
                t.setVestiaire(rs.getString("vestiaire"));
                t.setStatus(rs.getString("status"));
                t.setPrix(rs.getInt("prix"));
                t.setDuree(rs.getInt("duree"));
                 terrains.add(t);}
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return terrains;}
*/

    @FXML
    void clearField(ActionEvent event) {
        tfid.setText(null);
        tfnom.setText(null);
        tfaddress.setText(null);
        tfgradin.setText(null);
        tfvestiaire.setText(null);
        tfstatus.setText(null);
        tfduree.setText(null);
        tfprix.setText(null);
        btnsave.setDisable(false);

    }


    @FXML
    void createTerrain(ActionEvent event) throws SQLException {
        ts.add(new Terrain(Integer.parseInt(tfid.getText()),tfaddress.getText(),
                tfgradin.getText(),tfvestiaire.getText(),(tfstatus.getText()),tfnom.getText(),Integer.parseInt(tfprix.getText()),Integer.parseInt(tfduree.getText())));
    }


    @FXML
    void deleteTerrain(ActionEvent event) {

    }

    @FXML
    void updateTerrain(ActionEvent event) throws SQLException {
       /* String query = "UPDATE user SET id = ?, address = ?, gradin = ?, vestiaire = ?, status = ?, nom = ?, duree = ?, prix = ? WHERE id = ?";
        connection = MyDatabase.getInstance().getConnection();
        try{
            t = connection.prepareStatement(query);
            t.setInt(1, Integer.parseInt(tfid.getText()));
            t.setString(1, tfaddress.getText());
            t.setString(1, tfgradin.getText());
            t.setString(1, tfvestiaire.getText());
            t.setString(1, tfstatus.getText());
            t.setString(1, tfnom.getText());
            t.setInt(1, Integer.parseInt(tfprix.getText()));
            t.setInt(1, Integer.parseInt(tfduree.getText()));
    showTerrains();
        }catch (SQLException e){
throw (new RuntimeException(e));
    }*/}
    @FXML
    void show(ActionEvent event) {
showTerrains();
    }
    /*@FXML
    void getData(MouseEvent event) {
        Terrain terrain = table.getSelectionModel().getSelectedItem();
        id = terrain.getId();
        tfaddress.setText(terrain.getAddress());
        tfgradin.setText(terrain.getGradin());
        tfvestiaire.setText(terrain.getVestiaire());
        tfstatus.setText(terrain.getStatus());
        tfnom.setText(terrain.getNomt());
        tfprix.setText(String.valueOf(terrain.getPrix()));
        tfduree.setText(String.valueOf(terrain.getDuree()));
        btnsave.setDisable(true);
*/


    }


