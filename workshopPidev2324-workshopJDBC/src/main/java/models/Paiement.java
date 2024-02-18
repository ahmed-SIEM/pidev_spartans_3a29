package models;

import java.time.LocalDateTime;

public class Paiement {
    private int idPaiement ;
    private Membre membre ;
    private LocalDateTime date ;
    private LocalDateTime heure ;

    public Paiement(int idPaiement, Membre membre, LocalDateTime date, LocalDateTime heure) {
        this.idPaiement = idPaiement;
        this.membre = membre;
        this.date = date;
        this.heure = heure;
    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "idPaiement=" + idPaiement +
                ", membre=" + membre +
                ", date=" + date +
                ", heure=" + heure +
                '}';
    }

}
