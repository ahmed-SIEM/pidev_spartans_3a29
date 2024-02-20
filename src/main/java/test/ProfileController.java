package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import models.User;
import services.GestionUser.UserService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.UnaryOperator;

public class ProfileController {

    @FXML
    private TextField InputAddress;

    @FXML
    private TextField InputAge;

    @FXML
    private TextField InputNom;

    @FXML
    private TextField InputPhone;

    @FXML
    private Button btnDesactiver;

    @FXML
    private Button btnSeeInformationuser;

    @FXML
    private Button btnUpdateProfile;

    @FXML
    private Button btnseeRoleTab;

    @FXML
    private Button btnuploadimage;

    @FXML
    private ImageView imgDelete;



    @FXML
    private PasswordField inputCPassword;



    @FXML
    private PasswordField inputPassword;

    @FXML
    private Text tdNomaffichage;

    @FXML
    private Text tfDatedecreation;

    @FXML
    private Text tfRoleAffichage;

    private User CurrentUser ;
    public void setData(User u) {
        CurrentUser = u ;
        tfRoleAffichage.setText(CurrentUser.getRole());
        tfDatedecreation.setText(CurrentUser.getDate_de_Creation());
        tdNomaffichage.setText(CurrentUser.getName());
        inputPassword.setText(CurrentUser.getPassword());
        inputCPassword.setText(CurrentUser.getPassword());

        InputAddress.setText(
                CurrentUser.getEmail().isEmpty() ? "" : CurrentUser.getEmail()
        );
        InputAge.setText(
                CurrentUser.getAge() == 0 ? "" : String.valueOf(CurrentUser.getAge())
        );
        InputNom.setText(
                CurrentUser.getName().isEmpty() ? "" : CurrentUser.getName()
        );
        InputPhone.setText(
                CurrentUser.getPhone() == 0 ? "" : String.valueOf(CurrentUser.getPhone())
        );
    }

    public void initialize() {
        // Define a UnaryOperator to filter out non-numeric characters
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Only allow digits
                return change; // Accept the change
            }
            return null; // Reject the change
        };

        // Create a TextFormatter with the filter
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        TextFormatter<String> textFormatter2 = new TextFormatter<>(filter);

        // Set the TextFormatter to the TextField
        InputPhone.setTextFormatter(textFormatter);
        InputAge.setTextFormatter(textFormatter2);
    }

    @FXML
    void DesactiverProfile(ActionEvent event) {

    }

    @FXML
    void RemoveImage(MouseEvent event) {

    }

    @FXML
    void SeeInformationElements(ActionEvent event) {

    }

    @FXML
    void SeeRoleElements(ActionEvent event) {

    }

    @FXML
    void changerphoto(ActionEvent event) {

    }

    @FXML
    void updateProfile(ActionEvent event) throws SQLException {
        if( !inputPassword.getText().equals(inputCPassword.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("mots de passe ne correspondent pas");
            alert.setContentText("mot de passe et confirmer le mot de mot de passe devraient avoir le même contenu");
            alert.setHeaderText("Warning Alert");
            alert.showAndWait();
            return ;
        }

        UserService us = new UserService();
        User UpdateUser = new User();
        UpdateUser.setAddress(InputAddress.getText());
        UpdateUser.setPhone(Integer.parseInt(InputPhone.getText()));
        UpdateUser.setPassword(inputPassword.getText());
        UpdateUser.setName(InputNom.getText());
        UpdateUser.setAge(Integer.parseInt(InputAge.getText()));
        us.update(UpdateUser,CurrentUser.getEmail());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Profil mis à jour avec succès\n");
        alert.setHeaderText("votre compte a été mis à jour");
        alert.showAndWait();
    }


}
