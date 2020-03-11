package util;

import service.UserService;

public class ValidatorMain {

    UserService userService = new UserService();
    public boolean validateUsername(String username){
        return userService.checkUsername(username);
    }
    public boolean passwordValidator(String password1, String password2){
        return password1.equals(password2);
    }
}
