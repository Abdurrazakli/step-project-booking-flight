package Controller;

import service.LoginService;
import ui.Console;
import ui.GuestMenu;
import util.Parser;
import util.TerminateProgram;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class AuthenticationController {

    LoginService loginService = new LoginService();
    RegisterController registerController = new RegisterController();
    LoginController loginController = new LoginController();
    TerminateProgram terminateProgram = new TerminateProgram();

    GuestMenu guestMenu = new GuestMenu();
    Parser parser = new Parser();
    Console console = new Console();
    int choice;
    boolean LOGINED = false;

    public void Authentication (){
        while (true){

            String s = console.readLine();
            if(parser.strToInt(console.read()).isPresent()){
                choice=parser.strToInt(s).get();
            }else {
                console.print("Please enter an integer");
            }

            switch (choice){
                case 1:guestMenu.menuOptions();break;//Should go main controller;
                case 2:registerController.register();break;
                case 3:
                    boolean LOGINED = loginController.login();
                    break;
                case 4:terminateProgram.terminate();break;
                default:console.print("Please enter correct ID!");
            }

        }
    }

    public void userRegistrationForm(){

    }

}