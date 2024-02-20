package models;

import java.util.Date;

public class User {
    private int id;
    private int age;
    private String image ;
    private int Phone ;
    private String role ;

    private Date Date_de_Creation;
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

    public Date getDate_de_Creation() {
        return Date_de_Creation;
    }

    public void setDate_de_Creation(Date date_de_Creation) {
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

    public User(int age, String email, String address, String password, String name, int phone , String role) {
        this.role = role;
        this.age = age;
        this.Email = email;
        this.Address = address;
        this.Password = password;
        this.name = name;
        this.Phone = phone;
    }

    public User(int age, String name, String address, String password,  int phone ) {
        this.age = age;
        this.Address = address;
        this.Password = password;
        this.name = name;
        this.Phone = phone;
    }



    public User(){}

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
