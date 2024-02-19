package entity;

public class Terrain {
    private int id;
    private String address;
    private String gardin;
    private String vestiaire;
    private String status;

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