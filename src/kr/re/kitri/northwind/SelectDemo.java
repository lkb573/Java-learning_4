package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class SelectDemo {
    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("loading OK");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String query =
                "select customerid, " +
                "       companyname, " +
                "       contactname, " +
                "       address, " +
                "       city, " +
                "       phone " +
                "from customers " +
                "order by contactname";

        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();


            while (rs.next()) {
                System.out.print(rs.getString(1) + '\t');
                System.out.print(rs.getString(2) + '\t');
                System.out.print(rs.getString(3) + '\t');
                System.out.print(rs.getString(4) + '\t');
                System.out.print(rs.getString(5) + '\t');
                System.out.println(rs.getString(6));
            }

            conn.close();

            System.out.println("INSERT OK");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
