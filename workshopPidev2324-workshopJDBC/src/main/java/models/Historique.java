package models;

public class Historique {
    private int idHistorique ;
    private Reservation reservation ;
    private String score ;

    public Historique(int idHistorique, Reservation reservation, String score) {
        this.idHistorique = idHistorique;
        this.reservation = reservation;
        this.score = score;
    }

    public int getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(int idHistorique) {
        this.idHistorique = idHistorique;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Historique{" +
                "idHistorique=" + idHistorique +
                ", reservation=" + reservation +
                ", score='" + score + '\'' +
                '}';
    }
}
