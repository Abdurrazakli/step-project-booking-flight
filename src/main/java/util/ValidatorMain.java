package util;

import dao.Database;
import service.UserService;

public class ValidatorMain {
    private Database db;
    UserService userService;
    public ValidatorMain(Database db){
        this.db = db;
        userService = new UserService(db);
    }

    public boolean validateUsername(String username){
        return userService.checkUsername(username);
    }
    public boolean passwordValidator(String password1, String password2){
        return password1.equals(password2);
    }
}
