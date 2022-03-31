package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://msz-test.chq8qedm9jee.eu-west-1.rds.amazonaws.com/";
        Connection connection = DriverManager.getConnection(url, "postgres", "1dQxvBLTEpKTfgxQGD5FN");

        Statement st = connection.createStatement();

        st.execute("DROP TABLE IF EXISTS students_Przetacki");
        st.execute("CREATE TABLE students_Przetacki(first_name varchar(50), last_name varchar(50) , class_id varchar(10))");
        st.execute("INSERT INTO students_Przetacki VALUES ('Piotr', 'Przetacki', '2tc')");

        ResultSet rs = st.executeQuery("SELECT last_name, class_id FROM students_Przetacki");
        while(rs.next()){
            System.out.println(rs.getString("last_name") + " " + rs.getString("class_id"));
        }

        st.close();
        connection.close();
    }
}
