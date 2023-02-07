package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try (Connection conn = DriverManager.getConnection(url, account, pwd)){
            DatabaseMetaData metaData = conn.getMetaData();
            // Six methods with metaData to get information
            System.out.println(metaData.getDatabaseProductName());
            System.out.println(metaData.getDatabaseProductVersion());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getDriverVersion());
            System.out.println(metaData.getURL());
            System.out.println(metaData.getUserName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
