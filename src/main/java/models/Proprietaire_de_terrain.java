package models;

public class Proprietaire_de_terrain extends User {
    public Proprietaire_de_terrain(int id, int age, int phone, String role,String verificationCode, String date_de_Creation, String email, String address, String password, String name) {
        super(id, age, phone,verificationCode, role, date_de_Creation, email, address, password, name);
    }

    public Proprietaire_de_terrain(int age, int phone, String role,String verificationCode, String date_de_Creation, String email, String password, String name, String status) {
        super(age, phone, role,verificationCode, date_de_Creation, email, password, name, status);
    }

    public Proprietaire_de_terrain() {
    }
}
