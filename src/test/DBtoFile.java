package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class DBtoFile {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=EasonDatabase;encrypt=false";
        String account = "sa";
        String pwd = "1234";
        try(Connection conn = DriverManager.getConnection(url, account, pwd)) {
            String sql = "select fileName,MyFile from [fileTable] where filename = 'aaa.jpg'";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
                FileOutputStream fos = new FileOutputStream("c://java//123.jpg");
                InputStream binaryStream = rs.getBinaryStream(2);
                int data = 0;
                while ((data = binaryStream.read()) != -1) {
                    fos.write(data);
                }
                fos.flush();//沖出
                fos.close();
                binaryStream.close();
                System.out.println("OK");
            }
        }catch (SQLException e1) {
            e1.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }

    }
}
