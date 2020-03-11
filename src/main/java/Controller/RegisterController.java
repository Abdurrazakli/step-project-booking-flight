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

                console.print("Enter name: \n");
                name = console.readLine();
                console.print("Enter surname: \n");
                surname = console.readLine();
                console.print("Enter username: \n");
                while (true){
                    if(validatorMain.usernameValidation(console.read())) break;
                }
                console.print("Enter password: \n");
                while(true){
                    password = console.readLine();
                    console.print("Enter password again: \n");
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
