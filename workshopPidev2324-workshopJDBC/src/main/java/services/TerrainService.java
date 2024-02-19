/*package services;

import entity.Terrain;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrainService implements ITerrain<Terrain> {

    private Connection connection;

    public TerrainService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    public void add(Terrain t) throws SQLException{
        String query = "INSERT INTO user (age, name) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getAge());
        ps.setString(2, t.getName());
        ps.executeUpdate();
    }

    public void update(Terrain t) throws SQLException{
        String query = "UPDATE user SET age = ?, name = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getAge());
        ps.setString(2, t.getName());
        ps.setInt(3, t.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException{
        String query = "DELETE FROM user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<Terrain> getAll() throws SQLException{
        List<Terrain> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Terrain user = new Terrain();
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return users;
    }

    public Terrain getById(int id) throws SQLException{
        Terrain user = new Terrain();
        String query = "SELECT * FROM user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
        }
        return user;
    }
}
*/