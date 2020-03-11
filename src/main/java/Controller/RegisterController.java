package Controller;

import dao.UserDAO;
import entity.User;
import service.RegisterService;
import service.UserService;
import ui.Console;
import util.ValidatorMain;

public class RegisterController {
    RegisterService registerService = new RegisterService();
    UserService userService = new UserService();
    UserDAO userDAO = new UserDAO();
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
                while (true){ if(validatorMain.validateUsername(console.readLine())) break; }
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
                return userService.createNewUser(new User(name, surname, username, password));
    }
}
