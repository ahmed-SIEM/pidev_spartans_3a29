package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.User;
import services.GestionUser.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class AcceuilController {


    @FXML
    private Text Username;

    @FXML
    private Button btnseeProfile;

    private User CurrentUser ;
    public void setData(User u) {
        this.CurrentUser = u ;
        Username.setText(u.getName());


    }

    @FXML
    void btnseeProfile(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = loader.load();


            ProfileController profilecontroler = loader.getController();


            profilecontroler.setData(CurrentUser);


            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) btnseeProfile.getScene().getWindow()).close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

}
