package test;

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
        Tournoi tr1 = new Tournoi(20,"gafsaEVENT","","Ariana","12/12/2024","04/11/2025",2);
        St.ajouter(tr1);
        ServiceParticipation Sp = new ServiceParticipation();
        Participation pa1 = new Participation(2,"gafsa sports",7);

        Sp.ajouter(pa1);
        St.supprimer(8);
        St.modifier(new Tournoi(7,20,"EVENT","","Ariana","12/12/2024","04/11/2025",2));


        Participation pa2 = new Participation(2,"gafsa tournoi",7);
        Sp.ajouter(pa2);
    }
}
