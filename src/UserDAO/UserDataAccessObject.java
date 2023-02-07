package UserDAO;

import java.sql.*;
import java.util.ArrayList;

import Bean.User;
import connectionUtil.ConnectionFactory;

public class UserDataAccessObject implements InterfaceUserDAO {

	//C
	@Override
	public boolean createUser(User user) {
		String sql = "insert into [UserAccount] (id, account, pwd) "
				+ "values (?, ?, ?)";
		ConnectionFactory connFactory = new ConnectionFactory();
		try {
			Connection conn = connFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getAccount());
			pstmt.setString(3, user.getPwd());
			int updateCount = pstmt.executeUpdate();
			if (updateCount < 1) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		return false;
	}

	//R
	@Override
	public User findUserById(int id) {
		String sql = "select id, account, pwd from [UserAccount] where id=?";
		ConnectionFactory connFactory = new ConnectionFactory();
		try (Connection conn = connFactory.getConnection();) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 移動到cursor1
			rs.next();
			// Put cursor1 data to new a User
			User user = new User();
			user.setId(rs.getInt(1));
			user.setAccount(rs.getString(2));
			user.setPwd(rs.getString(3));
			return user;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		return null;
	}

	@Override
	public ArrayList<User> findAllUser() {
		ArrayList<User> users = new ArrayList<>();
		int count_id = 0;
		String sql = "select id, account, pwd from [UserAccount]";

		ConnectionFactory connFactory = new ConnectionFactory();
		try (Connection conn = connFactory.getConnection();) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			// 移動到cursor1
			while (rs.next()) {
				// Put cursor data to new a User
				User user = new User();
				user.setId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPwd(rs.getString(3));
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}

		return null;
	}

	//U
	@Override
	public boolean updateUser(User user) {
		String sql = "UPDATE [UserAccount] SET" +
				" account = ?," +
				" pwd = ? " +
				"WHERE id = ?";
		ConnectionFactory connFactory = new ConnectionFactory();
		try (Connection conn = connFactory.getConnection();) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getAccount());
			pstmt.setString(2, user.getPwd());
			pstmt.setInt(3, user.getId());
			int updateCount = pstmt.executeUpdate();
			if(updateCount >= 1) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		return false;
	}

		//D
	@Override
	public boolean deleteUserById(int id) {
		String sql = "delete from [UserAccount] where id=?;";
		ConnectionFactory connFactory = new ConnectionFactory();
		try (Connection conn = connFactory.getConnection();) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		return false;
	}
}
