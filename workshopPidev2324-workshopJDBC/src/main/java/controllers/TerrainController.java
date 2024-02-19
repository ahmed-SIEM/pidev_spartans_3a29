package controllers;

import com.mysql.cj.jdbc.JdbcConnection;
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
import utils.MyDatabase;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TerrainController implements Initializable {
    Connection connection = null;
    PreparedStatement t = null;
    ResultSet rs = null;

    @FXML
    private Button btnclear;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnupdate;



    @FXML
    private TextField tfaddress;

    @FXML
    private TextField tfgradin;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfstatus;

    @FXML
    private TextField tfvestiare;

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
    private TableView<Terrain> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    showTerrains();
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
                t.setAddress(rs.getString("address"));
                t.setGardin(rs.getString("gradin"));
                t.setVestiaire(rs.getString("vestiaire"));
                t.setStatus(rs.getString("status"));
                terrains.add(t);



            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return terrains;
    }
public void showTerrains(){
        ObservableList<Terrain> list = getTerrain();
        table.setItems(list);
        idc.setCellValueFactory(new PropertyValueFactory<Terrain,Integer>("id"));
        caddress.setCellValueFactory(new PropertyValueFactory<Terrain,String>("address"));
        cgradin.setCellValueFactory(new PropertyValueFactory<Terrain,String>("gradin"));
        cvestiaire.setCellValueFactory(new PropertyValueFactory<Terrain,String >("vestiaire"));
        cstatus.setCellValueFactory(new PropertyValueFactory<Terrain,String>("status"));


}

    @FXML
    void clearField(ActionEvent event) {

    }

    @FXML
    void createTerrain(ActionEvent event) {
    String insert = "insert into terrain(id,address,gradin,vestiaire,status) values(?,?,?,?,?)";
    connection = MyDatabase.getInstance().getConnection();
    try {
         t = connection.prepareStatement(insert);
         t.setString(1,tfid.getText());
         t.setString(2,tfaddress.getText());
         t.setString(3,tfgradin.getText());
         t.setString(4,tfvestiare.getText());
         t.setString(5,tfstatus.getText());
         t.executeUpdate();
         showTerrains();

    }   catch (SQLException e){
        throw new RuntimeException(e);
    }
    }

    @FXML
    void deleteTerrain(ActionEvent event) {

    }

    @FXML
    void updateTerrain(ActionEvent event) {

    }


}
