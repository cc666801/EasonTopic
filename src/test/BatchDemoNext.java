package test;

import javax.swing.*;
import java.sql.*;

public class BatchDemoNext {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try (Connection conn = DriverManager.getConnection(url, account, pwd)){
            String sql = "insert into mycustomers(name) values (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            String name = "";

            // 重複添加
            // M1
//            while((name = JOptionPane.showInputDialog("name")) != null) {
//                pstmt.setString(1, name);
//                pstmt.addBatch();
//            }

            // M2
            pstmt.setString(1, "ae");
            pstmt.addBatch();
            pstmt.setString(1, "af");
            pstmt.addBatch();
            pstmt.setString(1, "ag");
            pstmt.addBatch();
            pstmt.setString(1, "ah");
            pstmt.addBatch();
            pstmt.setString(1, "ai");
            pstmt.addBatch();

            pstmt.executeBatch();
            System.out.println("OK");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }
    }
}
