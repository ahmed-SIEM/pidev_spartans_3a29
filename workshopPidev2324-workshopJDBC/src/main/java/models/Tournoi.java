package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tournoi {

    private int id ;
    private int  nbrquipeMax ;
    private String nom ;

    private String affiche ;
    private String Address ;
    private String datedebut;
    private String datefin;

    private List<Participation> participationList ;

    private Organisateur org ;

    public Tournoi(int id, int nbrquipeMax, String nom, String affiche, String address, String datedebut, String datefin, Organisateur org) {
        this.id = id;
        this.nbrquipeMax = nbrquipeMax;
        this.nom = nom;
        this.affiche = affiche;
        this.Address = address;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.participationList = new ArrayList<>();
        this.org = org;
    }
    public Tournoi() {
    }

    public Tournoi( int nbrquipeMax, String nom, String affiche, String address, String datedebut, String datefin, Organisateur org) {
        this.nbrquipeMax = nbrquipeMax;
        this.nom = nom;
        this.affiche = affiche;
        this.Address = address;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.participationList = new ArrayList<>();
        this.org = org;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrquipeMax() {
        return nbrquipeMax;
    }

    public void setNbrquipeMax(int nbrquipeMax) {
        this.nbrquipeMax = nbrquipeMax;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    public Organisateur getOrg() {
        return org;
    }

    public void setOrg(Organisateur org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "id=" + id +
                ", nbrquipeMax=" + nbrquipeMax +
                ", nom='" + nom + '\'' +
                ", affiche='" + affiche + '\'' +
                ", Address='" + Address + '\'' +
                ", datedebut='" + datedebut + '\'' +
                ", datefin='" + datefin + '\'' +
                ", participationList=" + participationList +
                ", org=" + org +
                '}';
    }
}
