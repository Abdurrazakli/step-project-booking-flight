package Controller;

import entity.User;
import service.FlightService;
import service.LoginService;
import service.UserService;
import ui.Console;
import ui.Messages;
import util.Parser;
import util.TerminateProgram;

import java.util.Optional;

public class LoginController {
    private LoginService loginService = new LoginService();
    private UserService userService = new UserService();
    private FlightController flightController = new FlightController();
    private FlightService flightService = new FlightService();
    private BookingController bookingController = new BookingController();
    private TerminateProgram terminator = new TerminateProgram();
    private Console console = new Console();
    private Parser parser = new Parser();
    private String username;
    private String password;
    private String destination,date,numberOfSeats;
    private int userChoice;

    public Optional<User> login(){
        console.print("Please enter your username: ");
        username = console.readLine();
        console.print("Please enter your password: ");
        password = console.readLine();
        Optional<User> user = userService.checkUsernameAndPassword(username, password);
        if(user.isPresent()){
            console.print("Successfully Logged In!");
            loginMenu(user.get());
            return user;
        }else {
            console.print("Username or password is wrong!");
            return Optional.empty();
        }
    }
    private void loginMenu(User LOGGED_IN_USER){
        while(true){
            boolean logout=false;
            console.print(Messages.showLoggedUserMenu());
            console.print("Heyyo welcome!");
            String s = console.readLine();
            if(parser.strToInt(s).isPresent()){
                userChoice =parser.strToInt(s).get();
            }else {
                console.print("Please enter an integer");
            }
            switch (userChoice){
                case 1: flightController.showAllFlights();break;
                case 2: flightController.showAllFlightByFlightNumber(getFlightNumber());break;
                case 3: flightController.showSearchedFlight(flightController.searchFlights());break;
                case 4: bookingController.bookMe(LOGGED_IN_USER); break;
                case 5: bookingController.cancelMyFlight(LOGGED_IN_USER);break;
                case 6: bookingController.myFlights(LOGGED_IN_USER);break;
                case 7: logout=true;break;
                case 8: terminator.terminate();
                default:console.print("Enter a valid command!");break;

            }
            if(logout){
                break;
            }
        }

    }

    private String getFlightNumber() {
        console.print("Enter Flight Number: (for ex:TCN345)");
        return console.readLine();
    }
}
