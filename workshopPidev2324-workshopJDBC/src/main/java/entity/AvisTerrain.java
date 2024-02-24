package entity;
public class AvisTerrain {
    private int id;
    private String address;
    private String gradin;
    private int vestiaire;
    private String status;
    private String nomt;
    private int prix;
    private  int duree;

    public AvisTerrain(String address, String gradin, int vestiaire, String status, String nomt, int prix, int duree) {
        this.address = address;
        this.gradin = gradin;
        this.vestiaire = vestiaire;
        this.status = status;
        this.nomt = nomt;
        this.prix = prix;
        this.duree = duree;}
    @Override
    public String toString() {
        return "Terrain{" +
                ", id='" + id + '\'' +
                ", nomt='" + nomt + '\'' +
                ", address='" + address + '\'' +
                ", gradin='" + gradin + '\'' +
                ", vestiaire='" + vestiaire + '\'' +
                ", status='" + status + '\'' +
                ", prix=" + prix +
                ", duree=" + duree +
                '}';}
    public String getNomt() {
        return nomt;}

    public void setNomt(String nomt) {
        this.nomt = nomt;}

    public AvisTerrain() {}

    public int getPrix() {
        return prix;}

    public void setPrix(int prix) {
        this.prix = prix;}

    public int getDuree() {
        return duree;}

    public void setDuree(int duree) {
        this.duree = duree;}

    public String getAddress() {
        return address;}

    public void setAddress(String address) {
        this.address = address;}

    public String getGradin() {
        return gradin;}

    public int getId() {
        return id;}

    public void setId(int id) {
        this.id = id;}

    public void setGradin(String gardin) {
        this.gradin = gardin;}

    public int getVestiaire() {
        return vestiaire;}

    public void setVestiaire(int vestiaire) {
        this.vestiaire = vestiaire;}

    public String getStatus() {
        return status;}

    public void setStatus(String status) {
        this.status = status;}
}