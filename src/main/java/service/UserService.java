package service;

import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean checkUsername(String username){
        return userDAO.getAll().stream().filter(user -> user.username.equals(username)).toArray().length == 0;
    }
    public Optional<User> checkUsernameAndPassword(String username, String password){
        Optional<User> user = userDAO.getAll().stream().filter(user1 -> user1.username.equals(username)).findAny();
        if(user.isPresent() && user.get().password.equals(password)){
            return user;
        }
        return Optional.empty();
    }
    public boolean createNewUser(User user){
        return userDAO.create(user);
    }
    public void logout(){
        // what to do???
        throw new IllegalArgumentException("Not impl yet");
    }
}
