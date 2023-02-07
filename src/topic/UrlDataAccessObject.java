package topic;

import Bean.User;
import UserDAO.InterfaceUserDAO;

import java.util.ArrayList;

public class UrlDataAccessObject implements InterfaceUserDAO {
    //C
    public boolean createUser(User user){
        return false;
    };

    //R
    public User findUserById(int id){
        return null;
    };

    public ArrayList<User> findAllUser() {
        return null;
    };

    //U
    public boolean updateUser(User user) {
        return false;
    };

    //D
    public boolean deleteUserById(int id){
        return false;
    };
}
