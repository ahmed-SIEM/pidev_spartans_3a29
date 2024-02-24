package test;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.scene.text.Text;

import javafx.util.Duration;
import models.*;
import services.GestionUser.SMSAPI;
import services.GestionUser.UserService;
import services.GestionUser.VerificationCodeGenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.function.UnaryOperator;



public class LoginRegistrationPageController {

    public Text Registeragelabel;
    public TextField Registerfield111numero;
    public TextField Registerfield21age;
    public Text RegisterLabel111numero;
    @FXML
    private Button BtnSinscrire;

    @FXML
    private Button RegisterBtnSinscrire;

    @FXML
    private Text RegisterHeader;

    @FXML
    private Text RegisterLabel1;

    @FXML
    private Text RegisterLabel2;

    @FXML
    private Text RegisteraddressLabel;

    @FXML
    private TextField Registerfield1;

    @FXML
    private TextField Registerfield2;

    @FXML
    private Text Registerlabel12;

    @FXML
    private PasswordField Registerpass1;

    @FXML
    private Text Registertxt2;

    @FXML
    private Text Registrertxt1;

    @FXML
    private AnchorPane RightPane;

    @FXML
    private Text SeconnecterLabel1;

    @FXML
    private Text SeconnecterLabel2;

    @FXML
    private AnchorPane MainPane;
    @FXML
    private PasswordField SeconnecterPass1;

    @FXML
    private Text SeconnecterTxt1;

    @FXML
    private Text SeconnecterTxt2;

    @FXML
    private Button Seconnecterbtn1;

    @FXML
    private Button Seconnecterbtn2;

    @FXML
    private ToggleGroup radiobuttons;

    @FXML
    private TextField Seconnecterfield1;

    @FXML
    private Text Seconnecterheader;

    @FXML
    private Button btnSeconnecter;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private RadioButton rbtn1;

    @FXML
    private RadioButton rbtn2;

    @FXML
    private RadioButton rbtn3;

    @FXML
    private RadioButton rbtn4;

    @FXML
    private PasswordField registerPass2;

    UserService us = new UserService();

    private User CurrentUser ;
    public void setData(User us) {

        this.CurrentUser = us;
        Seconnecterfield1.setText(us.getEmail());
        SeconnecterPass1.setText(us.getPassword());
    }

    public void initialize() throws SQLException {



        UnaryOperator<TextFormatter.Change> filterPhone = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length()<=8 ) {
                return change;
            }
            return null;
        };
        UnaryOperator<TextFormatter.Change> filterAge = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length()<=2) {
                return change;
            }
            return null;
        };

          
             



        TextFormatter<String> textFormatter = new TextFormatter<>(filterPhone);
        TextFormatter<String> textFormatter2 = new TextFormatter<>(filterAge);
       
    

        Registerfield111numero.setTextFormatter(textFormatter);
        Registerfield21age.setTextFormatter(textFormatter2);
      

    }

    public boolean isValidName(String name){
        return name.matches("^[a-zA-Z]*$");
    }
    public boolean isValidEmail(String email){
        return email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }
    public boolean isValidPassword(String password){
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }


    public void SinscrireSlideBtn(ActionEvent actionEvent) {

       Seconnecterheader.setVisible(false);
        SeconnecterLabel1.setVisible(false);
        Seconnecterfield1.setVisible(false);
        SeconnecterLabel2.setVisible(false);
        SeconnecterPass1.setVisible(false);
        Seconnecterbtn1.setVisible(false);
        Seconnecterbtn2.setVisible(false);
        SeconnecterTxt1.setVisible(false);
        SeconnecterTxt2.setVisible(false);
        BtnSinscrire.setVisible(false);

        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(1), leftPane);
        transition1.setToX(leftPane.getTranslateX() + 300); // Move left by 50 pixels (adjust as needed)
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), RightPane);
        transition2.setToX(RightPane.getTranslateX() - 880 ); // Move left by 50 pixels (adjust as needed)
        transition1.play();
        transition2.play();


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            Registeragelabel.setVisible(true);
            Registerfield111numero.setVisible(true);
            Registerfield21age.setVisible(true) ;
                    RegisterLabel111numero.setVisible(true);
            RegisterBtnSinscrire.setVisible(true);
            RegisterHeader.setVisible(true);
            RegisterLabel1.setVisible(true);
            RegisterLabel2.setVisible(true);
            RegisteraddressLabel.setVisible(true);
            Registerfield1.setVisible(true);
            Registerfield2.setVisible(true);
            Registerlabel12.setVisible(true);
            Registerpass1.setVisible(true);
            Registertxt2.setVisible(true);
            Registrertxt1.setVisible(true);
            btnSeconnecter.setVisible(true);
            rbtn1.setVisible(true);
            rbtn2.setVisible(true);
            rbtn3.setVisible(true);
            rbtn4.setVisible(true);
            registerPass2.setVisible(true);
        }));
        timeline.play();


    }

    public void gotoSeconnecter(){
        Registeragelabel.setVisible(false);
        Registerfield111numero.setVisible(false);
        Registerfield21age.setVisible(false) ;
        RegisterLabel111numero.setVisible(false);
        RegisterBtnSinscrire.setVisible(false);
        RegisterHeader.setVisible(false);
        RegisterLabel1.setVisible(false);
        RegisterLabel2.setVisible(false);
        RegisteraddressLabel.setVisible(false);
        Registerfield1.setVisible(false);
        Registerfield2.setVisible(false);
        Registerlabel12.setVisible(false);
        Registerpass1.setVisible(false);
        Registertxt2.setVisible(false);
        Registrertxt1.setVisible(false);
        btnSeconnecter.setVisible(false);
        rbtn1.setVisible(false);
        rbtn2.setVisible(false);
        rbtn3.setVisible(false);
        rbtn4.setVisible(false);
        registerPass2.setVisible(false);


        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(1), leftPane);
        transition1.setToX(leftPane.getTranslateX() - 300); // Move left by 50 pixels (adjust as needed)
        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(1), RightPane);
        transition2.setToX(RightPane.getTranslateX() + 880); // Move left by 50 pixels (adjust as needed)
        transition1.play();
        transition2.play();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            Seconnecterheader.setVisible(true);
            SeconnecterLabel1.setVisible(true);
            Seconnecterfield1.setVisible(true);
            SeconnecterLabel2.setVisible(true);
            SeconnecterPass1.setVisible(true);
            Seconnecterbtn1.setVisible(true);
            Seconnecterbtn2.setVisible(true);
            SeconnecterTxt1.setVisible(true);
            SeconnecterTxt2.setVisible(true);
            BtnSinscrire.setVisible(true);
        }));
        timeline.play();
    }

    public void SeconnecterSlideBtn(ActionEvent actionEvent) {
        gotoSeconnecter();

    }
CAlert Al = new CAlert();
    @FXML
    public void Oublietlemotdepass(ActionEvent event) throws Exception {
        if(Seconnecterfield1.getText().isEmpty()){
            Al.generateAlert("WARNING","Tous les champs sont requis");
            return;

        }
        if(!us.userExist(Seconnecterfield1.getText())){
            Al.generateAlert("WARNING","Aucun utilisateur avec cet e-mail");
            return;
        }
        User u = us.getByEmail(Seconnecterfield1.getText());
        if( Al.generateConfirmation("Un code de vérification sera envoyé à votre teléphone Voulez-vous continuer?")){
            Al.generateConfirmation("Un code de vérification a été envoyé à votre teléphone");
            // i want a new scene to be generatd with a textfield to enter the code
            // if the code is correct then we can get the user and change the password
            // if the code is incorrect we can generate an alert
            // if the user wants to cancel the operation we can go back to the login page
            // if the user wants to resend the code we can resend the code
            SMSAPI sms = new SMSAPI();
            String code = VerificationCodeGenerator.generateVerificationCode();
            sms.SendCode(String.valueOf(u.getPhone()), code);


            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerificationCode.fxml"));
            AnchorPane root = loader.load();
            VerificationCodeController verificationCodeController = loader.getController();
            verificationCodeController.setData(u,code);
            MainPane.getChildren().setAll(root);





       

    }
    }

    @FXML
    public void Seconnecter(ActionEvent event) throws SQLException {

        if(Seconnecterfield1.getText().isEmpty() || SeconnecterPass1.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ vide");
            alert.setHeaderText("Tous les champs sont requis");
            alert.showAndWait();
            return;
        }


        if (!us.Login(Seconnecterfield1.getText(),SeconnecterPass1.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ invalid");
            alert.setHeaderText("L'un des champs est incorrect");
            alert.showAndWait();
            return;
        }


        User u = us.getByEmail(Seconnecterfield1.getText());
        if( !u.getStatus()){
            if( Al.generateConfirmation("Your account is currently deactivated. Do you want to reactivate and log in?")){
                us.InvertStatus(u.getEmail());
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                    AnchorPane root = loader.load();


                    AcceuilController acceuilController = loader.getController();


                    acceuilController.setData(us.getByEmail(Seconnecterfield1.getText()));


                    MainPane.getChildren().setAll(root);



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                AnchorPane root = loader.load();


                AcceuilController acceuilController = loader.getController();


                acceuilController.setData(us.getByEmail(Seconnecterfield1.getText()));


                MainPane.getChildren().setAll(root);



            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



















    @FXML
    void sinscrire(ActionEvent event) throws Exception {


        if (Registerfield2.getText().isEmpty()
                || Registerfield1.getText().isEmpty()
                || Registerpass1.getText().isEmpty()
                || Registerfield111numero.getText().isEmpty()
                || Registerfield21age.getText().isEmpty()

        ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ vide");
            alert.setContentText("vous pouvez les remplir soigneusement");
            alert.setHeaderText("Tous les champs sont requis");
            alert.showAndWait();
            Registerfield1.setText("");
            Registerfield2.setText("");
            registerPass2.setText("");
            Registerpass1.setText("");
            Registerfield21age.setText("");
            Registerfield111numero.setText("");
            return;
        }

        if(!isValidName(Registerfield1.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nom invalide");
            alert.setContentText("le nom ne doit contenir que des lettres");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            Registerfield1.setText("");
            Registerfield2.setText("");
            registerPass2.setText("");
            Registerpass1.setText("");
            Registerfield21age.setText("");
            Registerfield111numero.setText("");
            return;
            
        }
        if(!isValidEmail(Registerfield2.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Email invalide");
            alert.setContentText("l'email doit être valide");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            Registerfield1.setText("");
            Registerfield2.setText("");
            registerPass2.setText("");
            Registerpass1.setText("");
            Registerfield21age.setText("");
            Registerfield111numero.setText("");
            return;
        }

        if(!isValidPassword(Registerpass1.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mot de passe invalide");
            alert.setContentText("le mot de passe doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            Registerfield1.setText("");
            Registerfield2.setText("");
            registerPass2.setText("");
            Registerpass1.setText("");
            Registerfield21age.setText("");
            Registerfield111numero.setText("");
            return;
           
        }
        if(Integer.parseInt(Registerfield21age.getText()) < 12){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" Age invalide");
             
           
            alert.setContentText(" L'age doit être supérieur à 12 ans");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            return;
        }

        if(!registerPass2.getText().equals(Registerpass1.getText()) ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("mots de passe ne correspondent pas");
            alert.setContentText("mot de passe et confirmer le mot de mot de passe devraient avoir le même contenu");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            Registerfield1.setText("");
            Registerfield2.setText("");
            registerPass2.setText("");
            Registerpass1.setText("");
            Registerfield21age.setText("");
            Registerfield111numero.setText("");

            return;
        }
        if(us.userExist(Registerfield2.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("l'utilisateur existe déjà");
            alert.setContentText("Il y a déjà un utilisateur avec cet e-mail");
            alert.setHeaderText("CAlert Alert");
            alert.showAndWait();
            Registerfield1.setText(""); // nom
            Registerfield2.setText(""); // address
            registerPass2.setText(""); // confirm pass
            Registerpass1.setText(""); // pass
            Registerfield21age.setText("");
            Registerfield111numero.setText("");
            return;
        }


        Roles role;
        User u1;
        if(rbtn1.isSelected()){
            role = Roles.Fournisseur ;



            u1 = new Fournisseur(
                    Registerfield2.getText(),
                    registerPass2.getText(),
                    Registerfield1.getText(),
                    Integer.parseInt(Registerfield21age.getText()),
                    Integer.parseInt(Registerfield111numero.getText()),
                    role
            );
            us.addFournisseur((Fournisseur) u1);
        } else if (rbtn2.isSelected()) {
            role = Roles.Proprietaire_de_Terrain;


            u1 = new Proprietaire_de_terrain(
                    Registerfield2.getText(),
                    registerPass2.getText(),
                    Registerfield1.getText(),
                    Integer.parseInt(Registerfield21age.getText()),
                    Integer.parseInt(Registerfield111numero.getText()),
                    role);
            us.addProprietairedeTerarin((Proprietaire_de_terrain) u1);
        } else if (rbtn3.isSelected()) {
            role = Roles.Organisateur;


            u1 = new Organisateur(
                    Registerfield2.getText(),
                    registerPass2.getText(),
                    Registerfield1.getText(),
                    Integer.parseInt(Registerfield21age.getText()),
                    Integer.parseInt(Registerfield111numero.getText()),
                    role);

            us.addOrganisateur((Organisateur)u1);
        }else{
            role = Roles.Joueur;


            u1 = new Joueur(
                    Registerfield2.getText(),
                    registerPass2.getText(),
                    Registerfield1.getText(),
                    Integer.parseInt(Registerfield21age.getText()),
                    Integer.parseInt(Registerfield111numero.getText()),
                    role);
            us.addJoueur((Joueur)u1);
        }



        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Compte créé avec succès");
        alert.setHeaderText("Votre Compte a été créé avec succès");
        alert.showAndWait();

        gotoSeconnecter();
        Seconnecterfield1.setText(Registerfield2.getText());
        SeconnecterPass1.setText(registerPass2.getText());






    }



}




























