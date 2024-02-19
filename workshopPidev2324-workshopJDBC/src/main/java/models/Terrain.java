package models;

import java.util.Objects;

public class Terrain {
    private int id;
    private String nomTerrain ;
    private String address;
    private boolean gardin;
    private boolean vestiaire;
    private boolean status;
    private int prix;
    private  int duree;

    public Terrain(String nomTerrain, String address, boolean gardin, boolean vestiaire, boolean status, int prix, int duree) {

        this.nomTerrain = nomTerrain;
        this.address = address;
        this.gardin = gardin;
        this.vestiaire = vestiaire;
        this.status = status;
        this.prix = prix;
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", nomTerrain='" + nomTerrain + '\'' +
                ", address='" + address + '\'' +
                ", gardin=" + gardin +
                ", vestiaire=" + vestiaire +
                ", status=" + status +
                ", prix=" + prix +
                ", duree=" + duree +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGardin() {
        return gardin;
    }

    public void setGardin(boolean gardin) {
        this.gardin = gardin;
    }

    public boolean isVestiaire() {
        return vestiaire;
    }

    public void setVestiaire(boolean vestiaire) {
        this.vestiaire = vestiaire;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
