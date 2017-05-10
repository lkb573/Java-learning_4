package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Cusjoinorder;
import kr.re.kitri.northwind.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static kr.re.kitri.northwind.InsertDemo.PASSWORD;
import static kr.re.kitri.northwind.JdbcFinalDemo.DB_URL;
import static kr.re.kitri.northwind.SelectDemo.USERNAME;


public class JdbcService {

    public List<Customer> makeList() {

        String query =
                "select customerid, " +
                        "companyname, " +
                        "contactname, " +
                        "address, " +
                        "city, " +
                        "phone " +
                "from customers " +
                "order by contactname";


        List<Customer> list = new ArrayList<>();

        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                list.add(new Customer(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }





    public List<Cusjoinorder> joinList() {

        String query =
                "select a.contactname, a.city, a.country, b.orderdate, b.shipcountry " +
                        "from customers a, orders b " +
                        "where a.customerid = b.customerid ";


        List<Cusjoinorder> list = new ArrayList<>();

        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                list.add(new Cusjoinorder(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5)));

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }
}