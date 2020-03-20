package service;

import dao.Database;
import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    private Database db;
    public UserService(Database db) {
        this.db = db;
    }

    public boolean checkUsername(String username) {
        return db.userDAO.getAll().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public Optional<User> getValidatedUser(String username, String password){
        Optional<User> user = db.userDAO.getAll().stream().filter(user1 -> user1.getUsername().equals(username)).findAny();
        if(user.isPresent() && user.get().getPassword().equals(password)){
            return user;
        }
        return Optional.empty();
    }

    public boolean createNewUser(User user){
        return db.userDAO.create(user);
    }

}
