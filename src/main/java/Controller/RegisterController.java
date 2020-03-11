package Controller;

import dao.UserDAO;
import entity.User;
import service.RegisterService;
import service.UserService;
import ui.Console;
import util.ValidatorMain;

public class RegisterController {
    UserService userService = new UserService();
    Console console = new  Console();
    ValidatorMain validatorMain = new ValidatorMain();
    String name,surname,username,password;

    public boolean register(){
                console.print("====Registration Form====");

                console.print("Enter name: ");
                name = console.readLine();
                console.print("Enter surname: ");
                surname = console.readLine();
                console.print("Enter username: ");
                username = console.readLine();
                while (true){
                    if(!userService.checkUsername(username)) break;
                }
                console.print("Enter password: ");
                password = console.readLine();
                console.print("Enter password again: ");
                 while(true){
                    String password2 = console.read();
                    if(!validatorMain.passwordValidator(password,password2)){
                        console.print("Try Again!");
                    }else {
                        break;
                    }
                }
                console.print("Registered!");
                User user = new User(name, surname, username, password);
                System.out.println(username);
                return userService.createNewUser(user);
    }
}
