package test;

import Bean.User;
import UserDAO.UserDataAccessObject;

import java.util.ArrayList;

public class TestUserDAO {

	public static void main(String[] args) {
		// 單元測試
		UserDataAccessObject userDAO = new UserDataAccessObject();

		// C boolean createUser(User user)
		User user = new User();
		user.setId(5);
		user.setAccount("a523");
		user.setPwd("456");
//		userDAO.createUser(user);

		// R User findUserById(int id)
//		System.out.printf("%3s %8s %8s %n",
//				userDAO.findUserById(3).getId(),
//				userDAO.findUserById(3).getAccount(),
//				userDAO.findUserById(3).getPwd());


		// R ArrayList<User> findAllUser()
//		ArrayList<User> users = userDAO.findAllUser();
//		for (User user1:users) {
//			System.out.println(user1.getId());
//		}

		// U boolean updateUser(User user)
//		user.setAccount("a523");
//		userDAO.updateUser(user);

		// D boolean deleteUserById(int id)
//		userDAO.deleteUserById(2);
	}
}
