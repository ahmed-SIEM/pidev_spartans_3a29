package services;


import models.Equipe;
import models.Membre;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class EquipeService {
        private Connection connection;

        public EquipeService() {
            connection = MyDatabase.getInstance().getConnection();
        }

        public void ajouterEquipe(Equipe equipe) throws SQLException {
            String query = "INSERT INTO equipe (nomEquipe) VALUES (?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, equipe.getNomEquipe());
                ps.executeUpdate();
            }
        }

        public List<Equipe> getEquipesParMembre(int idMembre) throws SQLException {
            List<Equipe> equipes = new ArrayList<>();
            String query = "SELECT e.* FROM equipe e JOIN membreParEquipe mpe ON e.idEquipe = mpe.idEquipe WHERE mpe.idMembre = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, idMembre);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Equipe equipe = new Equipe();
                        equipe.setIdEquipe(rs.getInt("idEquipe"));
                        equipe.setNomEquipe(rs.getString("nomEquipe"));
                        equipe.setNbreJoueur(rs.getInt("nbreJoueur"));

                        equipes.add(equipe);
                    }
                }
            }
            return equipes;
        }

        public List<Membre> getMembresByEquipe(int idEquipe) throws SQLException {
            List<Membre> membres = new ArrayList<>();
            String query = "SELECT m.* FROM membre m JOIN membreParEquipe me ON m.idMembre = me.idMembre WHERE me.idEquipe = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, idEquipe);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Membre membre = new Membre();
                        membre.setId(rs.getInt("idMembre"));
                        membre.setNom(rs.getString("nom"));
                        membre.setPrenom(rs.getString("prenom"));
                        // Set other member attributes as needed
                        membres.add(membre);
                    }
                }
            }
            return membres;
        }


        public void supprimerEquipe(int idEquipe) throws SQLException {
            String query = "DELETE FROM equipe WHERE idEquipe = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, idEquipe);
                ps.executeUpdate();
            }
        }
    }


