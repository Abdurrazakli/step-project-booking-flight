package Controller;

import dao.UserDAO;
import entity.User;
import service.RegisterService;
import ui.Console;

public class RegisterController {
    RegisterService registerService = new RegisterService();
    UserDAO userDAO = new UserDAO();
    Console console = new  Console();
    String name,surname,username,password;
    public boolean register(){

                console.print("Enter name: \n");
                name = console.read();
                console.print("Enter surname: \n");
                surname = console.read();
                console.print("Enter username: \n");
                username = console.read();
                console.print("Enter password: \n");
                while(true){
                    password = console.read();
                    console.print("Enter password again: \n");
                    String password2 = console.read();
                    if(!password.equals(password2)){
                        console.print("Try Again!");
                    }else {
                        break;
                    }
                }
                return userDAO.create(new User(name, surname, username, password));
    }
}
