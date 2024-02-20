package services;

import models.Terrain;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrainService {
    private Connection connection;

    public TerrainService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    public void add(Terrain t) throws SQLException {
        String query = "INSERT INTO terrain (id,address,gradin,vestiaire,status,nom,duree,prix) VALUES (?, ?, ?, ? ,? ,? ,? ,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getId());
        ps.setString(2, t.getAddress());
        ps.setString(6, t.getNomTerrain()); // Corrected field name
        ps.setBoolean(4, t.isVestiaire());
        ps.setBoolean(5, t.isStatus());
        ps.setBoolean(3, t.isGardin());
        ps.setInt(7, t.getDuree());
        ps.setInt(8, t.getPrix());
        ps.executeUpdate();
    }
    public void update(Terrain t) throws SQLException{
        String query = "UPDATE user SET id = ?, address = ?, gradin = ?, vestiaire = ?, status = ?, nom = ?, duree = ?, prix = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getId());
        ps.setString(2, t.getAddress());
        ps.setString(6, t.getNomTerrain()); // Corrected field name
        ps.setBoolean(4, t.isVestiaire());
        ps.setBoolean(5, t.isStatus());
        ps.setBoolean(3, t.isGardin());
        ps.setInt(7, t.getDuree());
        ps.setInt(8, t.getPrix());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException{
        String query = "DELETE FROM terrain WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<Terrain> getAll() throws SQLException {
        List<Terrain> terrains = new ArrayList<>();
        String query = "SELECT * FROM terrain";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Terrain terrain = new Terrain();
            terrain.setId(rs.getInt("id"));
            terrain.setNomTerrain(rs.getString("nom"));
            terrain.setAddress(rs.getString("address"));
            terrain.setGardin(rs.getBoolean("gradin"));
            terrain.setVestiaire(rs.getBoolean("vestiaire"));
            terrain.setStatus(rs.getBoolean("status"));
            terrain.setDuree(rs.getInt("duree"));
            terrain.setPrix(rs.getInt("prix"));

            terrains.add(terrain);
        }
        return terrains;
    }

    public Terrain getById(int id) throws SQLException {
        Terrain terrain = new Terrain();
        String query = "SELECT * FROM terrain WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            terrain.setNomTerrain(rs.getString("nom"));
            terrain.setAddress(rs.getString("address"));
            terrain.setGardin(rs.getBoolean("gradin")); // Corrected field name
            terrain.setVestiaire(rs.getBoolean("vestiaire"));
            terrain.setStatus(rs.getBoolean("status"));
            terrain.setDuree(rs.getInt("duree"));
            terrain.setPrix(rs.getInt("prix"));
        }
        return terrain;
    }
}
