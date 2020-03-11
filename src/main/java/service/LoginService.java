package service;

import entity.User;
import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();

    public Optional<User> login(String username, String password){
        return userService.checkUsernameAndPassword(username,password);
    }
}
