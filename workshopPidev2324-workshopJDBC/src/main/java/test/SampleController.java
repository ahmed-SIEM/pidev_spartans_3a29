package test;

<<<<<<< Updated upstream
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SampleController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
=======

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SampleController {

    @FXML
    private Button forgetpasswordbutton;

    @FXML
    private Button submitbutton;

    @FXML
    private TextField tfaddress;

    @FXML
    private PasswordField tfmotdepass;

    @FXML
    void forgetpassword(ActionEvent event) {

        System.out.println("forgetpassword");


    }

    @FXML
    void submit(ActionEvent event) {

        System.out.println("submit");
    }



}


>>>>>>> Stashed changes
