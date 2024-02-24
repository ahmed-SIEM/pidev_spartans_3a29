package models;

public class BlackList {
    private int idBlackList ;

    private Reservation reservation ;
    private int duree ;
    private String cause ;

    public BlackList() {
    }

    public BlackList( int idMembre, int idTerrain, Reservation reservation, int duree, String cause) {

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
                ", reservation=" + reservation +
                ", duree=" + duree +
                ", cause='" + cause + '\'' +
                '}';
    }
}
