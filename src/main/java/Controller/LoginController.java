package Controller;

import entity.User;
import service.FlightService;
import service.LoginService;
import service.UserService;
import ui.Console;
import ui.Messages;
import util.Parser;

import java.util.Optional;

public class LoginController {
    LoginService loginService = new LoginService();
    UserService userService = new UserService();
    FlightController flightController = new FlightController();
    FlightService flightService = new FlightService();
    BookingController bookingController = new BookingController();
    Console console = new Console();
    Parser parser = new Parser();
    String username;
    String password;
    String destination,date,numberOfSeats;
    int userChoice;
    /*
        todo login boolean qaytarsin.
     Loginle bagli butun prosedurlar bu loginin icinde bas versin
     message gostermek
     menyu secimlerini etmek
     onlara uygun lazimi servisleri cagirmaq
     */
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
    private void loginMenu(User user){
        while(true){
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
                case 3: flightController.searchFlights();break;
                case 4: bookingController.bookAFlight(user);

            }
        }

    }

    private String getFlightNumber() {
        console.print("Enter Flight Number: (for ex:TCN345)");
        return console.readLine();
    }
}
