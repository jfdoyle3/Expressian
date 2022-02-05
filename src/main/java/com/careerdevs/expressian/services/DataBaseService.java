package com.careerdevs.expressian.services;

import com.careerdevs.expressian.entities.auth.ERole;
import org.springframework.stereotype.Service;
import java.sql.*;


@Service
public class DataBaseService {



    public boolean rolesExists() {
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");

            Statement statement = connection.createStatement();

            String query = "select count(*) from role";

            ResultSet results = statement.executeQuery(query);
            results.next();

            count = results.getInt(1);

            if (connection != null) {
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        }
        return false;
    }


    public void writeRoles() {

        int id = 0;

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");


            String sql = "INSERT INTO role (id, name) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (ERole role : ERole.values()) {
                statement.setString(1, Integer.toString(++id));
                statement.setString(2, role.toString());
                statement.executeUpdate();

            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Detects Table Exists
    private void tableExists(String databaseName, String tableName) {




        try {






            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");


            System.out.println("Opening Connection/nChecking if Table exists");

            DatabaseMetaData dbm = connection.getMetaData();

            ResultSet rs = dbm.getTables(null, databaseName, tableName, null);


            if (!rs.next()) {
                // If Table doesn't exist then....  do something
                System.out.println("Create Table here");
//                PreparedStatement create = connection.prepareStatement("create table role(name varchar(33))");
//                create.executeUpdate();
            } else {
                System.out.println("already exists");
            }

            if (connection != null) {
                System.out.println("Closing Connection");
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}