package test;

import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try (Connection conn = DriverManager.getConnection(url, account, pwd)) {


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
