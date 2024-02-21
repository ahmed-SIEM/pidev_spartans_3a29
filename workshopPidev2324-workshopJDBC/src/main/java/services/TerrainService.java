
package services;

import entity.Terrain;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrainService  implements ITerrain<Terrain>{

    private Connection connection;

    public TerrainService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    public void add(Terrain t) throws SQLException {
        String query = "INSERT INTO terrain (id,address,gradin,vestiaire,status,nom,duree,prix) VALUES (?, ?, ?, ? ,? ,? ,? ,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getId());
        ps.setString(2, t.getAddress());
        ps.setString(3, t.getGradin()); // Corrected field name
        ps.setInt(4, t.getVestiaire());
        ps.setString(5, t.getStatus());
        ps.setString(6, t.getNomt());
        ps.setInt(7, t.getDuree());
        ps.setInt(8, t.getPrix());
        ps.executeUpdate();
    }
    public void update(Terrain t) {
        String query = "UPDATE `terrain` SET  `address` = ?, `gradin` = ?, `vestiaire` = ?, `status` = ?, `nom` = ?, `duree` = ?, `prix` = ? WHERE `id` = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(8,t.getId());
            ps.setString(1, t.getAddress());
            ps.setString(2, t.getGradin()); // Corrected field name
            ps.setInt(3, t.getVestiaire());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getNomt());
            ps.setInt(6, t.getDuree());
            ps.setInt(7, t.getPrix());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

    }

    public void delete(int id) throws SQLException{
        String query = "DELETE FROM terrain WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<Terrain> getAll() throws SQLException{
        List<Terrain> terrains = new ArrayList<>();
        String query = "SELECT * FROM terrain";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Terrain terrain = new Terrain();
            terrain.setId(rs.getInt("id"));
            terrain.setNomt(rs.getString("nom"));
            terrain.setAddress(rs.getString("address"));
            terrain.setGradin(rs.getString("gradin"));
            terrain.setVestiaire(rs.getInt("vestiaire"));
            terrain.setStatus(rs.getString("status"));
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
            terrain.setNomt(rs.getString("nom"));
            terrain.setAddress(rs.getString("address"));
            terrain.setGradin(rs.getString("gradin")); // Corrected field name
            terrain.setVestiaire(rs.getInt("vestiaire"));
            terrain.setStatus(rs.getString("status"));
            terrain.setDuree(rs.getInt("duree"));
            terrain.setPrix(rs.getInt("prix"));
        }
        return terrain;
    }

}

