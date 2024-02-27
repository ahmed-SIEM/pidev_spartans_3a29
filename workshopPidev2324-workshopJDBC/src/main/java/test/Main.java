package test;

import models.Equipe;
import services.EquipeService;
import services.TerrainService;


import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        EquipeService equipeService = new EquipeService();
        List<Equipe> equipeList = equipeService.getEquipesParMembre(8);
        for (Equipe equipe :equipeList){
            System.out.println(equipe.toString());
        }
        TerrainService terrainService = new TerrainService();
        System.out.println(terrainService.getTerrainById(6));




      


    }
}
