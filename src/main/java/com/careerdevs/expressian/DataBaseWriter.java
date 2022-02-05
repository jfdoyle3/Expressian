package com.careerdevs.expressian;

import java.sql.*;

public class DataBaseWriter {

    public static void writeToDatabase() {


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");

            System.out.println("Opening connection");


            if (connection != null){
                System.out.println("Closing Connection");
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void tableRecordExists(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");
            System.out.println("Connection Open\nFinding if there are records on the table");

            // Checks the number of Records
            Statement stmt = connection.createStatement();
            //Query to get the number of rows in a table
            String query = "select count(*) from role";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);
            System.out.println("Number of records in the role table: "+count);

            if (connection != null){
                System.out.println("Closing Connection");
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void writeRoles(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");

            System.out.println("Connection Open\nWriting Roles to the table");
            // Write ERoles to table
            String[] roles=new String[]{"CUSTOMER","EMPLOYEE", "ADMIN"};
            int id=0;
            String sql = "INSERT INTO role (id, name) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (int idx = 0; idx < roles.length; idx++) {
                statement.setString(1, Integer.toString(++id));
                statement.setString(2, roles[idx]);
                statement.executeUpdate();

            }
            if (connection != null){
                System.out.println("Wrote Roles to database\nClosing Connection");
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // Detects Table Exists
    private void tableExists() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/expressian",
                    "username", "password");
            System.out.println("Opening Connection/nChecking if Table exists");
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet rs = dbm.getTables(null, "EXPRESSIAN", "ROLE", null);
            if (!rs.next()) {

       //  if doesn't exist need to kick and continue ..  OR need to put this after ExpressianApp
                PreparedStatement create = connection.prepareStatement("create table role(name varchar(33))");
                create.executeUpdate();
            }else{
                System.out.println("already exists");
            }

            if (connection != null){
                System.out.println("Closing Connection");
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}