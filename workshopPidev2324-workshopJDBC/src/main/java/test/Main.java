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
        // Tournoi tr1 = new Tournoi(20,"gafsaEVENT","","Ariana","12/12/2024","04/11/2025",2);
       //  St.ajouter(tr1);
        // ServiceParticipation Sp = new ServiceParticipation();


       //  St.supprimer(8);
       //  St.modifier(new Tournoi(7,20,"EVENT","","Ariana","12/12/2024","04/11/2025",2));


       // Participation pa3 = new Participation(2,"gafsa0",19);
       // Sp.ajouter(pa3);

        //ServiceParticipation sp = new ServiceParticipation();
       // System.out.println(sp.getNomsEquipesPourMembre(3));

        //Tournoi tr = new Tournoi(1,52,"ArianaEVENT","","Ariana","12/12/2024","04/11/2025");
      //  Participation pa3 = new Participation(3,"gafsa0",52);
        //tr.ajouterParticipation(pa3);

    }
}
