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

import java.io.IOException;

public class AcceuilController {

    @FXML
    private Text Username;

    @FXML
    private Button btnseeProfile;

    @FXML
    void btnseeProfile(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = loader.load();


            ProfileController profile = loader.getController();


            // registrationController.setData(...);


            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            ((Stage) btnseeProfile.getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  private User CurrentUser ;
    public void setData(User u) {
        this.CurrentUser = u ;
        Username.setText(u.getName());
    }
}
