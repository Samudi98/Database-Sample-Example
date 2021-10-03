package com.company;

import java.sql.*; // import the classes in the java.sql package

class DatabaseSample{
    public static void main (String args[]){ // to execute

        System.out.println("Program Initiated");
        // connecting to database

        Connection con = null;
        Statement stmt = null;

        try {
            System.out.println("Loading the driver");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // loading the MS Access

            //driver
            System.out.println("Connecting");
            con = DriverManager.getConnection("jdbc:odbc:odbc_ex");
            // odbc_ex is the data source name (DSN)

            System.out.println("Connected");

            // the transaction to be carried out - SQL statement

            String queryString = "insert into Student (id, first_name, last_name) values ('007','James','Bond')";

        //System.out.println(queryString);

            stmt = con.createStatement(); // creating the statement object to work database

            int i = stmt.executeUpdate(queryString); // returns an integer - number of
        // records added

            if (i != 0){
                System.out.println("Data update succeded");
            }
            else {
                System.out.println("Data update error");
            }
        // retrieve the data in the Names table

            queryString = "select * from Names";

            ResultSet rs = stmt.executeQuery(queryString); // query result is in rs object

            while (rs.next()){
                String id = rs.getString("id"); //
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                System.out.println("ID = "+id+ " First Name = "+fname+" Last Name = "+lname);
            }

            System.out.println("Thank you for using the database");

        } catch (SQLException e) {
            System.out.println("Cannot find the database");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the database");
        } finally {

            try{

                if(stmt != null) {
                    stmt.close();
                    stmt = null;
                }

                if(con != null) {
                    con.close();
                    con = null;
                }

            }catch (SQLException e) { }

        }

    }



    }
