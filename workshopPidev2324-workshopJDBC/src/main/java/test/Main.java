package test;

import entity.Terrain;
import controllers.TerrainController;
import services.TerrainService;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        TerrainController t = new TerrainController();
        Terrain t1 = new Terrain( "malek", "tunis", 23, "inexistant", "actif", 50, 60);

        TerrainService ts=new TerrainService();
        ts.update(t1);
    }}