package kr.re.kitri.northwind;


import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.service.JdbcService;

import java.util.List;

public class JdbcFinalDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";


    public static void main(String[] args){

        loadDriver(DRIVER_POSTGRES);
        JdbcService service = new JdbcService();

        List<Customer> list = service.makeList();

    }

    private static void loadDriver(String driverPostgres) {



    }
}