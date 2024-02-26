package test;

import models.Organisateur;
import models.Participation;
import models.Tournoi;
import services.GestionEvenement.ServiceParticipation;
import services.GestionEvenement.ServiceTournoi;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ServiceTournoi St = new ServiceTournoi();

     //  Tournoi tr = new Tournoi(1,20,"ArianaEVENT","","Ariana","12/12/2024","04/11/2025");
         // Tournoi tr = new Tournoi(20,"ArianaEVENT","","Ariana","12/12/2024","04/11/2025",1);

      //  St.ajouter(tr);

        ServiceParticipation Sp = new ServiceParticipation();

        Participation p = new Participation(1,"eop",3);

        Sp.ajouter(p);



    }
}
