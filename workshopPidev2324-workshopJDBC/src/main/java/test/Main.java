package test;

import entity.Terrain;
import services.TerrainService;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        TerrainService t = new TerrainService();
        Terrain t1 = new Terrain(123, "malek", "tunis", "existant", "inexistant", "actif", 50, 60);
    }}