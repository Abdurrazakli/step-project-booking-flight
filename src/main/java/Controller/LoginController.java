package Controller;

import entity.User;
import service.LoginService;
import service.UserService;
import ui.Console;

import java.util.Optional;

public class LoginController {
    LoginService loginService = new LoginService();
    UserService userService = new UserService();
    Console console = new Console();
    String username;
    String password;
    public Optional<User> login(){
        console.print("Please enter your username: ");
        username = console.readLine();
        console.print("Please enter your password: ");
        password = console.readLine();
        Optional<User> user = userService.checkUsernameAndPassword(username, password);
        if(user.isPresent()){
            return user;
        }else {
            console.print("Username or password is wrong!");
            return Optional.empty();
        }

    }
}
