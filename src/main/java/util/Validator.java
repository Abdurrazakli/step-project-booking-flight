package util;

import service.UserService;

import java.util.function.Function;

public interface Validator extends Function<String, ValidationMessage> {
    UserService USER_SERVICE = new UserService();
    static Validator validateUsername(){
        return username-> USER_SERVICE.checkUsername(username)?ValidationMessage.SUCCEED:ValidationMessage.USERNAME_EXISTS;
    }

}
enum ValidationMessage{
    SUCCEED,
    USERNAME_EXISTS,
}

