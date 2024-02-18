package test;

import models.User;
import services.GestionUser.UserService;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        UserService Us = new UserService();
        User u1 = new User(25,"kebsi@hotmail.com","tunis","1234","kebsi",12345678,"joueur");
        User u2 = new User(20,"hamdi@hotmail.com","marsa","1234","hamdi",12345678,"propriétaire de terrain");
        User u3 = new User(10,"hamdi@hotmail.com","marsa","1234","hamdi",12345678,"propriétaire de terrain");



        try {
            Us.delete("fdsf");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
