package Controller;

import service.LoginService;
import ui.ConsoleInput;

public class UserController {

    LoginService loginService = new LoginService();

    private String output(){
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("| 1.Login                                    |\n");
        sb.append("| 2.Register                                 |\n");
        sb.append("| 3.Exit                                     |\n");
        sb.append("|============================================|\n");
        sb.append("\n");
        return sb.toString();
    }

    public void controllerLoop(){
        while (){
            String s = ConsoleInput.scanner.nextLine();
            switch (Integer.parseInt(s)){
                case 1:
            }
        }
    }

    public void userRegistrationForm(){

    }



}
