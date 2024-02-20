package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.GestionUser.UserService;

import java.io.IOException;
import java.sql.SQLException;


public class SeconnecterController {

    @FXML
    private Button twitterlinkbtn;
    @FXML
    private Button facebooklinkbtn;
    @FXML
    private Button forgetpasswordbutton;

    @FXML
    private Button sinscrirebutton;

    @FXML
    private Button submitbutton;

    @FXML
    private TextField tfaddress;

    @FXML
    private PasswordField tfmotdepass;
    UserService  Us = new UserService();
    @FXML
    void forgetpassword(ActionEvent event) {
        System.out.println("forgetpassword");
    }

    @FXML
    void sinscrire(ActionEvent event) {
        try {
            // Load the FXML file for the registration scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
            Parent root = loader.load();

            // Get the controller for the registration scene
            RegistrationController registrationController = loader.getController();

            // Pass any data or variables if needed
            // registrationController.setData(...);

            // Switch to the registration scene
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) sinscrirebutton.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submit(ActionEvent event) throws SQLException {
        if(tfaddress.getText().equals("") || tfmotdepass.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ vide");
            alert.setHeaderText("Tous les champs sont requis");
            alert.showAndWait();
        } else if (!Us.Login(tfaddress.getText(),tfmotdepass.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ invalid");
            alert.setHeaderText("L'un des champs est incorrect");
            alert.showAndWait();

        }
        try {
            // Load the FXML file for the registration scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Base.fxml"));
            Parent root = loader.load();

            // Get the controller for the registration scene
            BaseController baseController = loader.getController();


             baseController.setData(Us.getByEmail(tfaddress.getText()));


            // Switch to the registration scene
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) sinscrirebutton.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void twitterlink(ActionEvent event) {
        openWebpage("https://twitter.com/your_twitter_handle");
    }
    @FXML
    void facebooklink(ActionEvent event) {
        openWebpage("https://www.facebook.com/your_facebook_page");
    }
    private void openWebpage(String url) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
