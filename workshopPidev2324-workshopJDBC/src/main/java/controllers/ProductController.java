package controllers;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Product;
import services.ProductService;


import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class ProductController implements Initializable {
    private ProductService rs=new ProductService();
    private String imagePath;
    private ObservableList<Product> dataList;

    @FXML
    private Button insert;
        @FXML
        private Button ajouter;
    @FXML
    private ImageView img;

    @FXML
    private Button insererimage;
        @FXML
        private TableColumn<Product, String> descriptionprod;

        @FXML
        private TextField descriptionprodf;
        @FXML
        private TextField recherche;
        @FXML
        private Button effacer;

        @FXML
        private TableColumn<Product, Integer> idprod;

        @FXML
        private TextField idprodf;
        @FXML
        private Button retour;

        @FXML
        private Button modifier;

        @FXML
        private TableColumn<Product, String> nomprod;

        @FXML
        private TextField nomprodf;

        @FXML
        private TableColumn<Product, Integer> prixprod;

        @FXML
        private TextField prixprodf;

        @FXML
        private Button supprimer;
    @FXML
    private TableColumn<Product, String> imageprod;


        @FXML
        private TableView<Product> tableau;

        public void showlist() throws SQLException {
            ProductService ps=new ProductService();
            List<Product> test = ps.getAll();
            idprod.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomprod.setCellValueFactory(new PropertyValueFactory<>("nom"));
            descriptionprod.setCellValueFactory(new PropertyValueFactory<>("description"));
            prixprod.setCellValueFactory(new PropertyValueFactory<>("prix"));
            imageprod.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableau.setItems((ObservableList<Product>) test);

        }
        @FXML
        public void SelectProduct()
        {   hide();
            Product product=tableau.getSelectionModel().getSelectedItem();
            int num =tableau.getSelectionModel().getSelectedIndex();
            if((num-1)<-1){return;}
            idprodf.setText(String.valueOf(product.getId()));
            nomprodf.setText(String.valueOf(product.getNom()));
            descriptionprodf.setText(String.valueOf(product.getDescription()));
            prixprodf.setText(String.valueOf(product.getPrix()));
            imagePath = product.getImage();
            Image image = new Image(imagePath);
            img.setImage(image);


        }

        public void addProduct() throws SQLException {
            Alert alert;
            if (nomprodf.getText().isEmpty()
                    || descriptionprodf.getText().isEmpty()
                    || prixprodf.getText().isEmpty()
                    ||  img.getImage().getUrl().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
            rs.add(new Product(nomprodf.getText(),descriptionprodf.getText(),Integer.parseInt(prixprodf.getText()),imagePath));
            showlist();

            effacer();
            }}

        public void deleteProduct() throws SQLException{
            int id = Integer.parseInt(idprodf.getText());
            if (id != -1) {
                try {
                    rs.delete(id);

                    showlist();
                    JOptionPane.showMessageDialog(null, "Delete Success!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("No item selected for deletion.");
            }
            effacer();
            //searchProduct();
        }

        public void editProduct() throws SQLException{
            try {
                int id = Integer.parseInt(idprodf.getText());
                String vnom=nomprodf.getText();
                String vdescription=descriptionprodf.getText();
                int vprix=Integer.parseInt(prixprodf.getText());
                imagePath = img.getImage().getUrl();



                Product c=new Product(vnom,vdescription,vprix,imagePath);
                rs.update(c,id);
                JOptionPane.showMessageDialog(null, "Update Success!");
                showlist();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            effacer();
        }
        public void hide()
        {
            imageprod.setVisible(false);
        }
    public void effacer() {
        nomprodf.setText("");
        idprodf.setText(null);
        descriptionprodf.setText("");
        prixprodf.setText(null);
        img.setImage(null);

    }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            try {
                hide();
                effacer();
                showlist();



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    @FXML
    void insererimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers image", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            img.setImage(image);}

    }
    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Products.fxml"));
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }



}




