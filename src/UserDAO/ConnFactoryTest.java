package UserDAO;

import java.sql.SQLException;

import connectionUtil.ConnectionFactory;

public class ConnFactoryTest {
	public static void main(String[] args) {
		ConnectionFactory conn = new ConnectionFactory();
		try {
			System.out.println(conn.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
