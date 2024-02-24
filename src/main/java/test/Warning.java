package test;


import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Warning {
    public void generateAlert( String type  , String Content ){
        switch(type) {
            case "WARNING":
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Warning");
                alert.setContentText(Content);
                alert.showAndWait();

                break;
            case "INFO":
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information");
                alert2.setHeaderText("Information");
                alert2.setContentText(Content);
                alert2.showAndWait();
                break;
           

            default:
                System.out.println("Unknown: " + Content);
        }

        

    }

    public boolean generateConfirmation( String Content ){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText(Content);

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
}