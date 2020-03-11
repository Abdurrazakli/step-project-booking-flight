package service;

import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean checkUsername(String username){
        return userDAO.getAll().stream().filter(user -> user.surname.equals(username)).toArray().length == 0;
    }
    public boolean createNewUser(User user){
        return userDAO.create(user);
    }
    public void logout(){
        // what to do???
        throw new IllegalArgumentException("Not impl yet");
    }
}
