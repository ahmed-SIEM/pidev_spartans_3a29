package services;
import entity.AvisTerrain;
import entity.Terrain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDatabase;
import java.sql.*;
//*******************************************************************************************
public class AvisService  implements ITerrain<AvisTerrain>{
    private Connection connection;
    //*******************************************************************************************
    public void addAvis(int terrainId, String commentaire, int note) throws SQLException {
        String sql = "INSERT INTO avis (terrain_id, commentaire, note) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, terrainId);
            statement.setString(2, commentaire);
            statement.setInt(3, note);
            statement.executeUpdate();}}
    //*******************************************************************************************
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
        ObservableList<AvisTerrain> avisTerrains = FXCollections.observableArrayList();
        String query = "SELECT avis.*, terrain.* FROM avis JOIN terrain ON avis.id = terrain.id";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AvisTerrain avisTerrain = new AvisTerrain();
                avisTerrain.setIdAvis(rs.getInt("idAvis"));
                avisTerrain.setCommentaire(rs.getString("commentaire"));
                avisTerrain.setNote(rs.getInt("note"));
                avisTerrain.setDate_avis(rs.getString("date_avis"));
                // Créer un objet Terrain avec les données de la jointure
                Terrain terrain = new Terrain();
                terrain.setId(rs.getInt("id"));
                terrain.setNomTerrain(rs.getString("nomTerrain"));
                // Assigner l'objet Terrain à l'objet AvisTerrain
                avisTerrain.setTerrain(terrain);
                avisTerrains.add(avisTerrain);}
        } catch (SQLException e) {
            e.printStackTrace();}
        return avisTerrains;}
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