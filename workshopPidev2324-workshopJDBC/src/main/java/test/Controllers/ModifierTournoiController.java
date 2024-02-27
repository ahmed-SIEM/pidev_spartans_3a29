package test.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Tournoi;
import services.GestionEvenement.ServiceTournoi;
import test.MainFx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ModifierTournoiController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        errorLabel2.setVisible(false);
        errorLabel3.setVisible(false);
        first = new ArrayList<>();
    }


    private List<Tournoi> first;



    @FXML
    private Button Btnback;

    @FXML
    private AnchorPane FormulaireRoot;

    @FXML
    private TextField InputAddress;

    @FXML
    private TextField InputNom;

    @FXML
    private TextField InputNombreéquipes;

    @FXML
    private Button btnAjouterTournoi;

    @FXML
    private Button btnSeeinformationsTournoi;

    @FXML
    private Button btnuploadimage;

    @FXML
    private ImageView imgview;

    @FXML
    private TextField InputDateDébut;

    @FXML
    private TextField InputDateFin;

    private String imagePath;

    @FXML
    private Label errorLabel;

    @FXML
    private Label errorLabel2;

    @FXML
    private Label errorLabel3;

    private Tournoi tournoiActuel;


    public void goToTournoi(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(MainFx.class.getResource("tournoi.fxml"));
        AnchorPane root = loader.load();
        FormulaireRoot.getChildren().setAll(root);
    }

    public void initData(Tournoi tournoi) {
        this.tournoiActuel = tournoi;
        InputNombreéquipes.setText(String.valueOf(tournoi.getNbrquipeMax()));
        InputNom.setText(tournoi.getNom());
        InputDateDébut.setText(tournoi.getDatedebut());
        InputDateFin.setText(tournoi.getDatefin());
        InputAddress.setText(tournoi.getAddress());
        imagePath = tournoi.getAffiche();
        if (imagePath != null && !imagePath.isEmpty()) {
            Image image = new Image(imagePath);
            imgview.setImage(image);
        }

    }

    private boolean validateDate() {
        String dateDebutText = InputDateDébut.getText();
        String dateFinText = InputDateFin.getText();

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateDebut = LocalDate.parse(dateDebutText, formatter);
            LocalDate dateFin = LocalDate.parse(dateFinText, formatter);

            if (dateDebut.isAfter(dateFin)) {
                errorLabel.setVisible(true);
                errorLabel.setText("La date de début doit être avant la date de fin.");
                return  false ;
            } else {
                errorLabel.setText("");
                return  true ;
            }
        } catch (DateTimeParseException e) {
            errorLabel.setVisible(true);
            errorLabel.setText("Format sous la forme dd/mm/aaaa svp .");
            return false ;
        }
    }

    private void validateNombreEquipes() {
        String nombreEquipesText = InputNombreéquipes.getText();
        if (Pattern.matches("^(8|16|24|48)$", nombreEquipesText)) {
            errorLabel2.setVisible(true);
            errorLabel2.setText("");
        } else {
            errorLabel2.setText("Le nombre d'équipes doit être 8, 16, 24, ou 48.");
        }
    }
    private void validateNom() {
        String nomText = InputNom.getText();

        // Utiliser une expression régulière pour valider le nom (lettres et chiffres seulement)
        if (Pattern.matches("^[a-zA-Z0-9]+$", nomText)) {
            errorLabel3.setText("");
        } else {
            errorLabel3.setVisible(true);
            errorLabel3.setText("Le nom ne doit contenir que des lettres et des chiffres.");
        }
    }

    @FXML
    void addimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers image", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            imagePath = selectedFile.toURI().toString();
            Image image = new Image(imagePath);
            imgview.setImage(image);}
    }

    public void ModifierTournoi(ActionEvent actionEvent) throws SQLException, IOException {

        ServiceTournoi ts = new ServiceTournoi();
        Tournoi tournoi = new Tournoi(tournoiActuel.getId(),Integer.parseInt(InputNombreéquipes.getText()), InputNom.getText(),imagePath,InputAddress.getText(), InputDateDébut.getText(), InputDateFin.getText(),2 );
        ts.modifier(tournoi);
        System.out.println(tournoi);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/test/tournoi.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Gestion_Tournoi");
        stage.setScene(new Scene(root));
        stage.show();
        ((Button) actionEvent.getSource()).getScene().getWindow().hide();
    }


}
