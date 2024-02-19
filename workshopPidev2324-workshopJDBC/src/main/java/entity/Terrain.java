package entity;

import java.util.Objects;

public class Terrain {
    private int id;
    private String address;
    private String gardin;
    private String vestiaire;
    private String status;
    private int prix;
    private  int duree;

    public Terrain(int id, String address, String gardin, String vestiaire, String status, int prix, int duree) {
        this.id = id;
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
                ", address='" + address + '\'' +
                ", gardin='" + gardin + '\'' +
                ", vestiaire='" + vestiaire + '\'' +
                ", status='" + status + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terrain terrain = (Terrain) o;
        return id == terrain.id && prix == terrain.prix && duree == terrain.duree && Objects.equals(address, terrain.address) && Objects.equals(gardin, terrain.gardin) && Objects.equals(vestiaire, terrain.vestiaire) && Objects.equals(status, terrain.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, gardin, vestiaire, status, prix, duree);
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

    public String getGardin() {
        return gardin;
    }

    public void setGardin(String gardin) {
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