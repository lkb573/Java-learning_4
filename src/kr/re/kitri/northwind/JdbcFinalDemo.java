package kr.re.kitri.northwind;


import kr.re.kitri.northwind.model.Cusjoinorder;
import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.service.JdbcService;

import java.sql.*;
import java.util.List;

public class JdbcFinalDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static String USERNAME = "postgres";
    public static String PASSWORD = "12345678";


    public static void main(String[] args){

        loadDriver(DRIVER_POSTGRES);
        JdbcService service = new JdbcService();

        List<Customer> list = service.makeList();

//        list.stream().forEach(x -> System.out.println(x));

        List<Cusjoinorder> jlist = service.joinList();

        jlist.stream().forEach(x -> System.out.println(x));
    }


    private static void loadDriver(String driverPostgres) {

        try {
            Class.forName(driverPostgres);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}