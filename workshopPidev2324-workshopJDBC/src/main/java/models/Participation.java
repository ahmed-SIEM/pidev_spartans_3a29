package models;

public class Participation {

    private int id ;
    private int idEquipe ;

    private boolean status ;

    private String dateC ;

    private int idTournoi;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getIdTournoi() {
        return idTournoi;
    }

    public void setIdTournoi(int idTournoi) {
        this.idTournoi = idTournoi;
    }

    public Participation(int id, int idEquipe, boolean status, String dateC, int idTournoi) {
        this.id = id;
        this.idEquipe = idEquipe;
        this.status = status;
        this.dateC = dateC;
        this.idTournoi = idTournoi;
    }

    public Participation() {

    }
}