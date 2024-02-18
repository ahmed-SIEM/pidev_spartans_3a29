package test;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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
