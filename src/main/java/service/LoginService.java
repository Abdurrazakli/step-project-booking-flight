package service;

import entity.User;
import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();

    public Optional<User> login(User newUer){
        return userService.checkUsername(newUer)?Optional.of(newUer):Optional.empty();
    }

}
