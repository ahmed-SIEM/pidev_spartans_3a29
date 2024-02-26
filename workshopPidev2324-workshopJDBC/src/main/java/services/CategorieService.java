package services;

import models.Categorie;
import utils.MyDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategorieService implements IService<Categorie> {

    private Connection connection;

    public CategorieService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void add(Categorie categorie) throws SQLException {

    }

    @Override
    public void update(Categorie categorie, int id) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public List<Categorie> getAll() throws SQLException {
        return null;
    }

    @Override
    public Categorie getById(int id) throws SQLException {
        return null;
    }
}
