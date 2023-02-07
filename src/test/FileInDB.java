package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileInDB {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try(Connection conn = DriverManager.getConnection(url, account, pwd)) {
            String sql = "insert into fileTable(fileName, MyFile) values (?. ?)";
            FileInputStream fis = new FileInputStream("C:/java/aaa.jpg");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "aaa.jpg");
            pstmt.setBinaryStream(2, fis);
            int count = pstmt.executeUpdate();
            System.out.println("OK:" + count);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
