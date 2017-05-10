package kr.re.kitri.northwind;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NorthwindMain {
    public static void main(String[] args){

        // 1.postgreSQL DB JDBC Driver loading
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("loading OK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        // 2.Connection object
        String dburl = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "12345678";


        try {

            Connection conn =
                DriverManager.getConnection(dburl, username, password);
            System.out.println("Connection OK");


            // 3.SQL query DB
            String sql =
                    "INSERT INTO public.sample(first_name, last_name, age) VALUES (?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"지성");
            pstmt.setString(2,"박");
            pstmt.setInt(3, 35);

            pstmt.executeUpdate();
            System.out.println("Insert OK");


            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}