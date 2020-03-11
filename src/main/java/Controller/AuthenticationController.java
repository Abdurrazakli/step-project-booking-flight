package Controller;

import entity.User;
import service.LoginService;
import ui.Console;
import ui.Messages;
import util.Parser;
import util.TerminateProgram;

import java.util.Optional;

public class AuthenticationController {

    LoginService loginService = new LoginService();
    RegisterController registerController = new RegisterController();
    LoginController loginController = new LoginController();
    TerminateProgram terminateProgram = new TerminateProgram();

    Parser parser = new Parser();
    Console console = new Console();
    int choice;
    boolean LOGINED = false;

    public void authentication(){
        System.out.println("AUTH");
        while (true){

            String s = console.readLine();
            if(parser.strToInt(console.read()).isPresent()){
                choice=parser.strToInt(s).get();
            }else {
                console.print("Please enter an integer");
            }

            switch (choice){
                case 1:
                    Messages.showGuestMenu();break;//Should go main controller;
                case 2:registerController.register();break;
                case 3:
                    Optional<User> loginedUser = loginController.login();
                    break;
                case 4:terminateProgram.terminate();break;
                default:console.print("Please enter correct ID!");
            }
        }
    }

    public void userRegistrationForm(){

    }

}