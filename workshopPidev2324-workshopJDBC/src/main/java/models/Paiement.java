package models;

import java.time.LocalDateTime;

public class Paiement {
    private int idPaiement ;
    private int idmembre ;
    private int idreservation ;
    private String date ;
    private String heure ;

    public Paiement( int idmembre, int idreservation, String date, String heure) {

        this.idmembre = idmembre;
        this.idreservation = idreservation;
        this.date = date;
        this.heure = heure;
    }

    public Paiement() {
    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public int getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(int idmembre) {
        this.idmembre = idmembre;
    }

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "idPaiement=" + idPaiement +
                ", idmembre=" + idmembre +
                ", idreservation=" + idreservation +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                '}';
    }
}
