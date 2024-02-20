package models;

public class BlackList {
    private int idBlackList ;
    private int idMembre ;
    private int idTerrain ;
    private Reservation reservation ;
    private int duree ;
    private String cause ;

    public BlackList() {
    }

    public BlackList( int idMembre, int idTerrain, Reservation reservation, int duree, String cause) {

        this.idMembre = idMembre;
        this.idTerrain = idTerrain;
        this.reservation = reservation;
        this.duree = duree;
        this.cause = cause;
    }

    public int getIdBlackList() {
        return idBlackList;
    }

    public void setIdBlackList(int idBlackList) {
        this.idBlackList = idBlackList;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "idBlackList=" + idBlackList +
                ", idMembre=" + idMembre +
                ", idTerrain=" + idTerrain +
                ", reservation=" + reservation +
                ", duree=" + duree +
                ", cause='" + cause + '\'' +
                '}';
    }
}
