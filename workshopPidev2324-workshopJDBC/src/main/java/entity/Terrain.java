package entity;

import java.util.Objects;

public class Terrain {
    private int id;
    private String nomt;
    private String address;
    private String gardin;
    private String vestiaire;
    private String status;
    private int prix;
    private  int duree;
    public Terrain(int id, String address, String gardin, String vestiaire, String status,String nomt, int prix, int duree) {
        this.id = id;
        this.address = address;
        this.gardin = gardin;
        this.vestiaire = vestiaire;
        this.status = status;
        this.nomt = nomt;
        this.prix = prix;
        this.duree = duree;
    }

  /*  public Terrain(int id, String nomt, String address, String gardin, String vestiaire, String status, int prix, int duree) {
        this.id = id;
        this.nomt = nomt;
        this.address = address;
        this.gardin = gardin;
        this.vestiaire = vestiaire;
        this.status = status;
        this.prix = prix;
        this.duree = duree;
    }*/


    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", nomt='" + nomt + '\'' +
                ", address='" + address + '\'' +
                ", gardin='" + gardin + '\'' +
                ", vestiaire='" + vestiaire + '\'' +
                ", status='" + status + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                '}';
    }

    public String getNomt() {
        return nomt;
    }

    public void setNomt(String nomt) {
        this.nomt = nomt;
    }

    public Terrain() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGradin() {
        return gardin;
    }

    public void setGradin(String gardin) {
        this.gardin = gardin;
    }

    public String getVestiaire() {
        return vestiaire;
    }

    public void setVestiaire(String vestiaire) {
        this.vestiaire = vestiaire;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}