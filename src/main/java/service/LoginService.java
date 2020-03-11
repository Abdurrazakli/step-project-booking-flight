package service;

import entity.User;
import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();

    public Optional<User> login(User newUser){
        return userService.checkUsername(newUser.username)?Optional.of(newUser):Optional.empty();
    }

}
