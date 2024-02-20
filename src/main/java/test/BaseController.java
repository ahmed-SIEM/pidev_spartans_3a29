package test;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BaseController {
    @FXML
    private Button btnshowuser;

    @FXML
    private Text tftext;
    @FXML
    private Text tfpassword;
    private User CurrentUser ;
    public void setData(User us) {
        this.CurrentUser = us;
    }


    @FXML
    void showuser(ActionEvent event) {
        tftext.setText(CurrentUser.getEmail());
        tfpassword.setText(CurrentUser.getPassword());

    }


    @FXML
    private Button uploadButton;

    @FXML
    private ImageView imageView;

    @FXML
    private void handleUploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(uploadButton.getScene().getWindow());
        if (selectedFile != null) {
            // Move the selected file to the resources folder
            try {
                Path targetPath = Paths.get("src/main/resources", selectedFile.getName());
                Files.move(selectedFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                Image image = new Image(targetPath.toUri().toString());
                imageView.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}


