package test;

import java.sql.*;

public class BatchDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try (Connection conn = DriverManager.getConnection(url, account, pwd)){
            Statement stmt = conn.createStatement();
            // Statement.addBatch( "sql指令" )
            stmt.addBatch("insert into mycustomers(name) values ('Bob5')");
            stmt.addBatch("Update [dbo].[MyCustomers] set [name] = 'Bob6' where id = 2");
            stmt.addBatch("Update [dbo].[MyCustomers] set [name] = 'Bob6' where id = 2");
            stmt.addBatch("insert into mycustomers(name) values ('Bob8')");
            stmt.addBatch("insert into mycustomers(name) values ('Bob9')");
            stmt.addBatch("Delete [dbo].[MyCustomers] where id = 4");
            // Set a array to save executeBatch
            int[] executeBatch = stmt.executeBatch();
            for (int i = 0; i < executeBatch.length; i++) {
                int j = executeBatch[i];
                System.out.println(j);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }
    }
}
