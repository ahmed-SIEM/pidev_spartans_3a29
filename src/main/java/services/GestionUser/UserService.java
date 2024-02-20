package services.GestionUser;

import models.User;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User> {

    private Connection connection;

    public UserService() {
        connection = MyDatabase.getInstance().getConnection();
    }



    public User getByEmail(String e) throws SQLException{
        User user = new User();
        String query = "SELECT * FROM user WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, e);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getInt("phone"));
            user.setRole(rs.getString("role"));
            user.setDate_de_Creation(rs.getString("DatedeCreation"));
            user.setImage(rs.getString("Image"));
        }
        return user;
    }

    public boolean userExist(String e) throws SQLException{
        String query = "SELECT COUNT(*) FROM user WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, e);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if(rs.getInt(1) == 0){
                return false;
            }
        }
        return true;


    }



    public void add(User t) throws SQLException{


        String query = "INSERT INTO user (email , password , name , role , DatedeCreation , status ) VALUES (?,?,?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, t.getEmail());
        ps.setString(2, t.getPassword());
        ps.setString(3, t.getName());
        ps.setString(4, t.getRole());
        ps.setString(5,t.getDate_de_Creation());
        ps.setString(6,t.getStatus());

        ps.executeUpdate();

    }


    public void delete(String email) throws SQLException{
        if(!userExist(email)){
            System.out.println("User does not exist");
            return;
        }
        String query = "DELETE FROM user WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ps.executeUpdate();
    }
    public void update(User t , String email) throws SQLException{

        String query = "UPDATE user SET age = ?, name = ?  , address = ? , password = ? , phone = ?  WHERE email = ?";


        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, t.getAge());
        ps.setString(2, t.getName());
        ps.setString(3, t.getAddress());
        ps.setString(4, t.getPassword());
        ps.setInt(5, t.getPhone());
        ps.setString(6, email);
        ps.executeUpdate();
    }

    public void updatePhoto(String Photo , String email) throws SQLException {
        String query = "UPDATE user SET Image = ?  WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, Photo);
        ps.setString(2,email);
        System.out.println("done image uploaded");
        ps.executeUpdate();
    }

    public List<User> getAll() throws SQLException{
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getInt("phone"));
            user.setRole(rs.getString("role"));

            users.add(user);
        }
        return users;
    }

    public boolean Login(String e , String P) throws SQLException{
        User U1 = getByEmail(e);
        return U1.getPassword().equals(P);
    }
}
