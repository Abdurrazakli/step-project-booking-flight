package service;

import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean checkUsername(User newUser){
        return userDAO.getAll().contains(newUser);
    }




    public void logout(){
        // what to do???
        throw new IllegalArgumentException("Not impl yet");
    }
}
