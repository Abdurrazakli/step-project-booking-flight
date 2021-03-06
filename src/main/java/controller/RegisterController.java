package controller;

import entity.User;
import service.UserService;
import ui.Console;
import util.Validator;

public class RegisterController {

    Console console;
    Validator validatorMain;
    UserService userService;
    String name;
    String surname;
    String username;
    String password;

    public RegisterController(Console console) {
        this.console = console;
        validatorMain = new Validator();
        userService = new UserService();
    }

    public boolean register(){
                console.print("====Registration Form====");

                console.print("Enter name: ");
                name = console.readLine();
                console.print("Enter surname: ");
                surname = console.readLine();
                console.print("Enter username: ");
                while (true){
                   username = console.readLine();
                    if(userService.checkUsername(username)){
                        console.print("Username already exists. Pick another username!!!");
                    }else {
                        break;
                    }
                }
                console.print("Enter password: ");
                password = console.readLine();
                console.print("Enter password again: ");
                 while(true){
                    String password2 = console.read();
                    if(!validatorMain.passwordValidator(password,password2)){
                        console.print("Enter validation password again!");
                    }else {
                        break;
                    }
                }
                console.print("Registered!");
                User user = new User(name, surname, username, password);
                console.print(String.format("%15s welcome!",username));
                return userService.createNewUser(user);//db
    }
}
