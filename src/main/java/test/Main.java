package test;

import models.User;
import services.GestionUser.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserService Us = new UserService();

        System.out.println(Us.getByEmail("aa"));






    }
}
