package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
public class RegistrationController {

    @FXML
    private Button btnSeconnecter;

    @FXML
    private Button btnsinscrire;

    @FXML
    private RadioButton rbtnfournisseur;

    @FXML
    private RadioButton rbtnjoueur;

    @FXML
    private RadioButton rbtnorganisateur;

    @FXML
    private RadioButton rbtnpropriéte;

    @FXML
    private PasswordField tdconfirmermotdepass;

    @FXML
    private PasswordField tdmotdepass;

    @FXML
    private TextField tfaddresselectronique;

    @FXML
    private TextField tfnom;

    @FXML
    void openseconnectertab(ActionEvent event) {
        if(rbtnfournisseur.isSelected()){
            System.out.println("you selected fournisseur");
        }
        if(rbtnjoueur.isSelected()){
            System.out.println("you selected rbtnjoueur");
        }
        if(rbtnorganisateur.isSelected()){
            System.out.println("you selected rbtnorganisateur");
        }
        if(rbtnpropriéte.isSelected()){
            System.out.println("you selected rbtnpropriéte");
        }

    }

    @FXML
    void sinscrire(ActionEvent event) {
        System.out.println("nom : " + tfnom.getText());
        System.out.println("addresselectronique : " + tfaddresselectronique.getText());
        System.out.println("motdepass : " + tdmotdepass.getText());
        System.out.println("confirmermotdepass : " + tdconfirmermotdepass.getText());

    }

}
