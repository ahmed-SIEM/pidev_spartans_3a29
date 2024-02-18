package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
<<<<<<< Updated upstream
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFx extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
=======
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFx.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 725, 613);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


>>>>>>> Stashed changes
}
