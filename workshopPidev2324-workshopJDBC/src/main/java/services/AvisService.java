package services;
import entity.AvisTerrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDatabase;
import java.sql.*;
//*******************************************************************************************
public class AvisService  implements ITerrain<AvisTerrain>{
    private Connection connection;
    public AvisService() {connection = MyDatabase.getInstance().getConnection();}
    //*******************************************************************************************
    public void add(AvisTerrain t) throws SQLException {
        String query = "INSERT INTO avis (id, commentaire, note, date_avis) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, t.getId()); // Utilisation de l'ID du terrain
            ps.setString(2, t.getCommentaire());
            ps.setInt(3, t.getNote());
            ps.setString(4, t.getDate_avis());
            ps.executeUpdate();
            // Récupère l'ID généré par la base de données
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    t.setIdAvis(rs.getInt(1));}}}}
    //*******************************************************************************************
    public void update(AvisTerrain t) {
        String query = "UPDATE `avis` SET  `commentaire` = ?, `note` = ?, `date_avis` = ? WHERE `idAvis` = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, t.getCommentaire());
            ps.setInt(2, t.getNote()); // Corrected field name
            ps.setString(3, t.getDate_avis());
            ps.setInt(4,t.getIdAvis());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());}}
    //*******************************************************************************************
    public void delete(int id) throws SQLException{
        String query = "DELETE FROM avis WHERE idAvis = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();}
    //*******************************************************************************************
    public ObservableList<AvisTerrain> getAllTerrains() {
        ObservableList<AvisTerrain> terrains = FXCollections.observableArrayList();
        String query = "SELECT * FROM avis";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AvisTerrain terrain = new AvisTerrain();
                terrain.setIdAvis(rs.getInt("idAvis"));
                terrain.setId(rs.getInt("id")); // Utilisez la colonne "id" pour l'ID du terrain
                terrain.setCommentaire(rs.getString("commentaire"));
                terrain.setNote(rs.getInt("note"));
                terrain.setDate_avis(rs.getString("date_avis"));
                terrains.add(terrain);}
        } catch (SQLException e) {
            e.printStackTrace();}
        return terrains;}
    //*******************************************************************************************
    public AvisTerrain getTerrainById(int id) {
        AvisTerrain terrain = null;
        String query = "SELECT * FROM avis WHERE idAvis = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                terrain = new AvisTerrain();
                terrain.setIdAvis(rs.getInt("idAvis"));
                terrain.setCommentaire(rs.getString("commentaire"));
                terrain.setNote(rs.getInt("note"));
                terrain.setDate_avis(rs.getString("date_avis"));}
        } catch (SQLException e) {
            e.printStackTrace();}
        return terrain;}}