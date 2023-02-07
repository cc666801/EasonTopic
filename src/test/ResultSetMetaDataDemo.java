package test;

import java.sql.*;

public class ResultSetMetaDataDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databasename=Northwind;encrypt=false";
        String account = "sa";
        String pwd = "1234";

        try (Connection conn = DriverManager.getConnection(url, account, pwd)){
            String sql = "select * from Employees";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // Get a ResultSet from PreparedStatement.executeQuery()
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println(metaData.getColumnCount());
            rs.next();
//            while (rs.next()) {
                // Use for loop to get columnName in ResultSet by rs.getMetaData()
                for (int i = 1; i < metaData.getColumnCount(); i++) {
                    // JDBC P96
                    System.out.println(metaData.getColumnName(i) + ":" + rs.getString(i));
                    System.out.println(metaData.getColumnLabel(i) + ":" + rs.getString(i));
                    System.out.println(metaData.getColumnType(i));
                    System.out.println(metaData.getColumnTypeName(i));
                    System.out.println(metaData.getColumnDisplaySize(i));
                    System.out.println(metaData.isNullable(i));

                }
//            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }
    }
}
