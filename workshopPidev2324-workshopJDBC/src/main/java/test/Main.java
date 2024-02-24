package test;
import entity.Terrain;
import controllers.TerrainController;
import services.TerrainService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        TerrainController t = new TerrainController();
        Terrain t1 = new Terrain("yy", true, true, true, "actif", 50, 60, "tunis", "img", "vid");
        TerrainService ts=new TerrainService();
        ts.add(t1);
        List<Terrain> terrainList = new ArrayList<>();
        terrainList = ts.getAllTerrains();
        for (Terrain tt : terrainList){

            System.out.println(tt.toString());

        }
    }}