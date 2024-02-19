package models;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int idReservation ;
    private boolean isConfirm ;
    private String dateReservation ;
    private String heureReservation ;
    private  TypeReservation type ;
    List<Terrain> listTerrain ;
    void addListe(Terrain terrain){
        this.listTerrain.add(terrain);
    }


    public List<Terrain> getListTerrain() {
        return listTerrain;
    }

    public Reservation() {
    }

    public Reservation(boolean isConfirm, String dateReservation, String heureReservation, TypeReservation type) {
        listTerrain = new ArrayList<>();
        this.isConfirm = isConfirm;
        this.dateReservation = dateReservation;
        this.heureReservation = heureReservation;
        this.type = type;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getHeureReservation() {
        return heureReservation;
    }

    public void setHeureReservation(String heureReservation) {
        this.heureReservation = heureReservation;
    }

    public String getType() {
        String t = this.type.name();
        return t;
    }

    public void setType(TypeReservation type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", isConfirm=" + isConfirm +
                ", dateReservation=" + dateReservation +
                ", heureReservation=" + heureReservation +
                ", type=" + type +
                '}';
    }
}
