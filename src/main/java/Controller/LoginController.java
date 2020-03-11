package Controller;

import entity.User;
import service.LoginService;
import ui.Console;

import java.util.Optional;

public class LoginController {
    LoginService loginService = new LoginService();
    Console console = new Console();
    String username;
    String password;
    public boolean login(){
        console.print("Please enter your username: ");
        username = console.readLine();
        console.print("Please enter your password: ");
        password = console.readLine();
        throw new RuntimeException("Yes");
    }
}
