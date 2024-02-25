package test;

import javafx.collections.ObservableList;
import models.Reservation;
import models.Terrain;
import models.User;
import services.ReservationService;
import services.TerrainService;


import java.sql.SQLException;
import java.util.List;

import static models.TypeReservation.ReserverTerrainPourEquipe;

public class Main {


    public static void main(String[] args) throws SQLException {
        TerrainService ts = new TerrainService();

        ObservableList<Terrain> terrains = ts.getAllTerrains();
        for (Terrain t : terrains){
            System.out.println(t.toString());
        }
        ReservationService reservationService = new ReservationService();
        boolean x = reservationService.VerfierDisponibleTerrain(5, 120, "19:00", "2024-02-26");
        System.out.println(x);




      


    }
}
