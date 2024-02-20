package models;

import java.sql.Date;
import java.time.LocalDate;

public class User {
    private int id;
    private int age;
    private String image ;
    private int Phone ;
    private String role ;

    private java.sql.Date Date_de_Creation;
    private String Email ;
    private String Address;

    private String Password;
    private String name;

    private String Status = "Active" ;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public java.sql.Date getDate_de_Creation() {
        return Date_de_Creation;
    }

    public void setDate_de_Creation(java.sql.Date date_de_Creation) {
        Date_de_Creation = date_de_Creation;
    }



    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name ;   }

    public void setName(String name) {
        this.name = name;    }


    public User(int id, int age, int phone, String role, Date date_de_Creation, String email, String address, String password, String name) {
        this.id = id;
        this.age = age;
        this.Phone = phone;
        this.role = role;
        this.Date_de_Creation = date_de_Creation;
        this.Email = email;
        this.Address = address;
        this.Password = password;
        this.name = name;

    }

    public User(String role, Date date_de_Creation, String email, String password, String name) {
        this.role = role;
        this.Date_de_Creation = date_de_Creation;
        this.Email = email;
        this.Password = password;
        this.name = name;

    }


    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Password='" + Password + '\'' +
                ", name='" + name + '\'' +
                ", Phone=" + Phone +
                ", role='" + role + '\'' +
                '}';
    }
}
