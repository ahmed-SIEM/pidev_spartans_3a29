package test;

import entity.Terrain;
import controllers.TerrainController;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        TerrainController t = new TerrainController();
        Terrain t1 = new Terrain(123, "malek", "tunis", "existant", "inexistant", "actif", 50, 60);
    }}