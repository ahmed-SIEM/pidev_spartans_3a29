package services;
import entity.AvisTerrain;
import utils.MyDatabase;
import java.sql.*;

public class AvisService  implements ITerrain<AvisTerrain>{
    private Connection connection;
    public AvisService() {
        connection = MyDatabase.getInstance().getConnection();}
    public void add(AvisTerrain t) throws SQLException {
        String query = "INSERT INTO terrain (address, gradin, vestiaire, status, nom, prix, duree) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, t.getAddress());
            ps.setString(2, t.getGradin());
            ps.setInt(3, t.getVestiaire());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getNomt());
            ps.setInt(6, t.getPrix());
            ps.setInt(7, t.getDuree());
            ps.executeUpdate();
            // Récupère l'ID généré par la base de données
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    t.setId(rs.getInt(1));}}}}

    public void update(AvisTerrain t) {
        String query = "UPDATE `terrain` SET  `address` = ?, `gradin` = ?, `vestiaire` = ?, `status` = ?, `nom` = ?, `duree` = ?, `prix` = ? WHERE `id` = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, t.getAddress());
            ps.setString(2, t.getGradin()); // Corrected field name
            ps.setInt(3, t.getVestiaire());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getNomt());
            ps.setInt(6, t.getDuree());
            ps.setInt(7, t.getPrix());
            ps.setInt(8,t.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());}}
    public void delete(int id) throws SQLException{
        String query = "DELETE FROM terrain WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();}
}