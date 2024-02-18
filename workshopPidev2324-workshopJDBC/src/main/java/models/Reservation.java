package models;

import java.time.LocalDateTime;

public class Reservation {
    private int idReservation ;
    private boolean isConfirm ;
    private LocalDateTime dateReservation ;
    private LocalDateTime heureReservation ;
    private  TypeReservation type ;

    public Reservation(int idReservation, boolean isConfirm, LocalDateTime dateReservation, LocalDateTime heureReservation, TypeReservation type) {
        this.idReservation = idReservation;
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

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDateTime getHeureReservation() {
        return heureReservation;
    }

    public void setHeureReservation(LocalDateTime heureReservation) {
        this.heureReservation = heureReservation;
    }

    public TypeReservation getType() {
        return type;
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
