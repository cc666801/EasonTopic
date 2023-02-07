package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=EasonDatabase;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try(Connection conn = DriverManager.getConnection(url, account, pwd)) {
            conn.prepareCall("{call get_customer_id_and_order_date(?, ?, ?)}");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
