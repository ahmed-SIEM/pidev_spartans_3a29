package test;

import javafx.collections.ObservableList;
import models.Equipe;
import models.Reservation;
import models.Terrain;
import models.User;
import services.EquipeService;
import services.ReservationService;
import services.TerrainService;


import java.sql.SQLException;
import java.util.List;

import static models.TypeReservation.ReserverTerrainPourEquipe;

public class Main {


    public static void main(String[] args) throws SQLException {
        EquipeService equipeService = new EquipeService();
        List<Equipe> equipeList = equipeService.getEquipesParMembre(8);
        for (Equipe equipe :equipeList){
            System.out.println(equipe.toString());
        }




      


    }
}
