package models;



public class User {
    private int id;

    private int age;

    private int Phone ;
    private Roles role ;









    private String Email ;
    private String Address;

    private String Password;
    private String name;







    public Roles getRole() {
        return role;
    }

    public void setRole(String role) {

        //convert string to role with switch case
        switch (role) {
            case "Fournisseur":
                this.role = Roles.Fournisseur;
                break;
            case "Joueur":

                this.role = Roles.Joueur;
                break;
            case "Organisateur":

                this.role = Roles.Organisateur;
                break;
            default:
                this.role = Roles.Proprietaire_de_Terrain;
                break;

        }





    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        this.Phone = phone;
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








    public User(){}
    public User(int id, String Email , String Password, String Name , int age , int Phone , String address , Roles role)  {
        this.id = id;
        this.Email = Email;
        this.Password = Password;
        this.name = Name;
        this.age = age;
        this.Phone = Phone;
        this.Address = address;
        this.role = role;


    }
    public User( String Email , String Password, String Name , int age , int Phone  , Roles role )  {
        this.Email = Email;
        this.Password = Password;
        this.name = Name;
        this.age = age;
        this.Phone = Phone;
        this.role = role;

    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", Phone=" + Phone +
                ", role=" + role +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Password='" + Password + '\'' +
                ", name='" + name + '\'' +

                '}';
    }
}
