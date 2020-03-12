package Controller;

import dao.Database;
import entity.User;
import service.UserService;
import ui.Console;
import ui.Messages;
import util.Parser;
import util.TerminateProgram;

import java.util.Optional;

public class LoginController {
    private UserService userService;
    private FlightController flightController;
    private BookingController bookingController;
    private TerminateProgram terminator;
    private Console console;
    private Database db;
    private String username;
    private String password;
    private int userChoice;
    public LoginController(Console console,Database db){
        this.console = console;
        this.db = db;
        flightController = new FlightController(this.console, db);
        bookingController = new BookingController(this.console,db);
        userService = new UserService(db);
        bookingController = new BookingController(this.console,db);
        terminator = new TerminateProgram();
    }
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
            userChoice = Parser.getUserChoice(console);
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
                console.print("Never come back!");
                break;
            }
        }

    }



    private String getFlightNumber() {
        console.print("Enter Flight Number: (for ex:TCN345)");
        return console.readLine();
    }
}
