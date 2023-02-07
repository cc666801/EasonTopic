package UserDAO;

import java.util.ArrayList;

import Bean.User;

public interface InterfaceUserDAO {

	//C
	boolean createUser(User user);

	//R
	User findUserById(int id);

	ArrayList<User> findAllUser();

	//U
	boolean updateUser(User user);

	//D
	boolean deleteUserById(int id);

}