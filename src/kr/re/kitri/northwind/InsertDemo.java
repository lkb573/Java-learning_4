package kr.re.kitri.northwind;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";

    public static void main(String[] args){

        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("loading OK");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String query =
                "INSERT INTO public.categories(categoryid, categoryname, description) " +
                "VALUES (?, ?, ?)";

        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1,101);
            pst.setString(2,"Desktop");
            pst.setString(3,"Stay home");


            pst.executeUpdate();

            System.out.println("INSERT OK");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
