package service;

import dao.UserDAO;
import entity.User;

import java.util.Optional;

public class UserService {
    public UserDAO userDAO = new UserDAO();

    public boolean checkUsername(User newUser){
        return userDAO.getAll().flatMap(users ->
                users.stream().filter(user ->
                        user.equals(newUser)).findAny())
                        .isPresent();
    }
    public boolean register(User newUser){
        return !checkUsername(newUser) && userDAO.create(newUser);
    }

    public Optional<User> login(User newUer){
        return checkUsername(newUer)?Optional.of(newUer):Optional.empty();
    }

    public void logout(){
        // what to do???
        throw new IllegalArgumentException("Not impl yet");
    }
}
