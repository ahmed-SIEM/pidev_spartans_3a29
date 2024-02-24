package entity;
public class AvisTerrain {
    private int idAvis;
    private String commentaire;
    private int note;
    private String date_avis;

    public AvisTerrain(String commentaire, int note, String date_avis) {
        this.commentaire = commentaire;
        this.note = note;
        this.date_avis = date_avis;}

    public AvisTerrain() {

    }

    public int getIdAvis() {return idAvis;}
    public void setIdAvis(int idAvis) {this.idAvis = idAvis;}
    public String getCommentaire() {return commentaire;}
    public void setCommentaire(String commentaire) {this.commentaire = commentaire;}
    public int getNote() {return note;}
    public void setNote(int note) {this.note = note;}
    public String getDate_avis() {return date_avis;}
    public void setDate_avis(String date_avis) {this.date_avis = date_avis;}
    @Override
    public String toString() {
        return "AvisTerrain{" +
                "idAvis=" + idAvis +
                ", commentaire='" + commentaire + '\'' +
                ", note=" + note +
                ", date_avis='" + date_avis + '\'' +
                '}';
    }
}