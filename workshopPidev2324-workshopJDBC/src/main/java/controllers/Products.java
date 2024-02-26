package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Product;
import services.ProductService;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Products implements Initializable {




    @FXML
    private AnchorPane BOX1;

    @FXML
    private AnchorPane BOX2;

    @FXML
    private AnchorPane BOX3;

    @FXML
    private ImageView Img1;

    @FXML
    private ImageView Img2;

    @FXML
    private ImageView Img3;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private Text address1;

    @FXML
    private Text address2;

    @FXML
    private Text address3;

    @FXML
    private Button btnDetail1;

    @FXML
    private Button btnModif1;

    @FXML
    private Button btnModif2;

    @FXML
    private Button btnModif3;

    @FXML
    private Button btnSupp1;

    @FXML
    private Button btnSupp2;

    @FXML
    private Button btnajout;

    @FXML
    private Button btndetail2;

    @FXML
    private Button btndetail3;

    @FXML
    private Button btnretour;

    @FXML
    private Button btnsuivant;

    @FXML
    private Button btnsupp3;

    @FXML
    private Text nom1;

    @FXML
    private Text nom2;

    @FXML
    private Text nom3;

    /*

    BOX1 :
    nom1
    address1
    btnDetail1
btnSupp1
btnModif1
Img1

    * */
    int i= 0;



    ProductService ps = new ProductService();



    void actualise(List<Product> products){
        if(products.size()-1-i*3>0){
            btnsuivant.setVisible(true);
        }

        if(products.size()-1-i*3 <= 0){
            btnsuivant.setVisible(false);
        }
        if(i > 0){
            btnretour.setVisible(true);
        }

        if(i == 0){
            btnretour.setVisible(false);
        }
        if(!products.isEmpty()){
            if(products.size()-1-i*3>=0){
                BOX1.setVisible(true);
                nom1.setText(products.get(i*3).getNom());
                address1.setText(products.get(i*3).getDescription());
                Img1.setImage(new Image(products.get(i*3).getImage()));

            }else{

                BOX1.setVisible(false);
            }
            if(products.size()-2-i*3>=0){
                BOX2.setVisible(true);
                nom2.setText(products.get(1+i*3).getNom());
                address2.setText(products.get(1+i*3).getDescription());
                Img2.setImage(new Image(products.get(1+i*3).getImage()));
            }else{
                BOX2.setVisible(false);
            }
            if(products.size()-3-i*3>=0){
                BOX3.setVisible(true);
                nom3.setText(products.get(2+i*3).getNom());
                address3.setText(products.get(2+i*3).getDescription());
                Img3.setImage(new Image(products.get(2+i*3).getImage()));
            }else{
                BOX3.setVisible(false);

            }


        }
    }
    @FXML
    void retour(ActionEvent event) {
        i -=1;
        try {
            actualise(ps.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void suivant(ActionEvent event) {
        i +=1;
        try {

            actualise(ps.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void Ajout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Product.fxml"));
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }



    @FXML
    void detail1(ActionEvent event) {

    }

    @FXML
    void detail2(ActionEvent event) {

    }

    @FXML
    void detail3(ActionEvent event) {

    }
    @FXML
    void Modif1(ActionEvent event) {

    }

    @FXML
    void modif2(ActionEvent event) {

    }

    @FXML
    void modif3(ActionEvent event) {

    }



    @FXML
    void supp1(ActionEvent event) throws SQLException {
        Alert alert;

        List<Product> products;
        try {
            products = ps.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!products.isEmpty()) {alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous supprimez ce produit " + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                if (products.size() - 1 - i * 3 >= 0) {
                ps.delete(products.get((i*3)).getId());
                JOptionPane.showMessageDialog(null, "Delete Success!");

            }
        }
    }}
    @FXML
    void supp2(ActionEvent event) throws SQLException {
        Alert alert;

        List<Product> products;
        try {
            products = ps.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!products.isEmpty()) {alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous supprimez ce produit " + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
            if (products.size() - 1 - i * 3 >= 0) {
                ps.delete(products.get((i*3)+1).getId());
                JOptionPane.showMessageDialog(null, "Delete Success!");

            }
        }

    }}

    @FXML
    void supp3(ActionEvent event) throws SQLException {
        Alert alert;
        List<Product> products;
        try {
            products = ps.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!products.isEmpty()) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous supprimez ce produit " + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                if (products.size() - 1 - i * 3 >= 0) {
                    ps.delete(products.get((i * 3) + 2).getId());
                    JOptionPane.showMessageDialog(null, "Delete Success!");

                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            actualise(ps.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}