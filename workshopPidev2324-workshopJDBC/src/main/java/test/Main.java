package test;
import entity.Terrain;
import controllers.TerrainController;
import services.TerrainService;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {
        TerrainController t = new TerrainController();
        Terrain t1 = new Terrain("tunis","hhh",23, "inexistant", "actif", 50, 60, "tunis", "img","vid");
        TerrainService ts=new TerrainService();
        ts.update(t1);}}