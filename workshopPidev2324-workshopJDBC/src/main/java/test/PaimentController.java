package test;

import javafx.event.ActionEvent;
import models.Paiement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import services.PaiementService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PaimentController {






        @FXML
        private TextField CVV;

        @FXML
        private TextField NOM;

        @FXML
        private TextField date;

        @FXML
        private TextField numero;




    public void PAYER(ActionEvent event) throws SQLException {
        //int idmembre, int idreservation, LocalDateTime date, LocalDateTime heure
        int idm = 1 ;
        int idr = 1 ;
        LocalDate dateCourrant = LocalDate.now();
        LocalTime timeCourrant = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = dateCourrant.format(formatter);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String heureEnString = timeCourrant.format(formatter2);


        Paiement paiement = new Paiement(idm,idr,dateString,heureEnString);
        PaiementService paiementService = new PaiementService();
        paiementService.payer(paiement);


    }
}
