package com.bogdan.faktury.db.dao;

import com.bogdan.faktury.db.Artykul;
import com.bogdan.faktury.db.Client;
import com.bogdan.faktury.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtykulDAO {
    public List<Artykul> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from artykul");
            List<Artykul> artykuls = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                artykuls.add(new Artykul(id, title, price));
            }
            return artykuls;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
