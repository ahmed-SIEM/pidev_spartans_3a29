package services.GestionEvenement;

import models.Organisateur;
import models.Participation;
import models.Tournoi;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceParticipation {

    private final Connection connection;

    public ServiceParticipation() {
        connection = MyDatabase.getInstance().getConnection();
    }
    public void ajouter(Participation J) throws SQLException {
        String Query = "INSERT INTO participation ( idequipe, idTournoi, Status, datec) VALUES (?,?,?,?)";
        PreparedStatement psParticipation = connection.prepareStatement(Query);
        psParticipation.setInt(1, J.getIdEquipe());
        psParticipation.setInt(2, J.getIdTournoi());
        psParticipation.setBoolean(3, J.isStatus());
        psParticipation.setString(4, J.getDateC());

        psParticipation.executeUpdate();
    }

    public void supprimer(int id) throws SQLException {

        String query = "DELETE FROM participation WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


    public Participation getbyidpart(int id) throws SQLException {
        Participation par = null;
        String query = "SELECT * FROM user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            par= new Participation();
            par.setId(rs.getInt("id"));
            par.setIdEquipe(rs.getInt("idequipe"));
            par.setIdTournoi(rs.getInt("idTournoi"));
            par.setStatus(rs.getBoolean("Status"));
            par.setDateC(rs.getString("datec"));

        }
        return par;
    }


    public List<Participation> allParticipation() throws SQLException {
        List<Participation> Tournois = new ArrayList<>();
        String query = "SELECT * FROM Tournoi";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {

            Participation pr = new Participation();

            pr.setId(rs.getInt("id"));
            pr.setIdEquipe(rs.getInt("NbmaxEquipe"));
            pr.setIdTournoi(rs.getInt("nom"));
            pr.setStatus(rs.getBoolean("affiche"));
            pr.setDateC(rs.getString("datedebut"));


            Tournois.add(pr);
        }
        return Tournois;
    }
}
