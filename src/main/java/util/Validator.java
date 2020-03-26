package util;

import entity.Flight;
import service.UserService;
import ui.Console;

import java.util.List;
import java.util.Optional;

public class Validator {
    UserService userService;
    private int flightIndex;
    public Validator(){
        userService = new UserService();
    }

    public int inputSearchedFlightValidator(Console console, List<Flight> flights){
        while(true){
            flightIndex = Parser.getUserChoice(console);
            Optional<Flight> foundedFlight = flights.stream().filter(flight ->
                    flight.getID() == flightIndex)
                    .findAny();
            if(foundedFlight.isPresent()){
                break;
            }else {
                console.print("Please enter searched flight index!");
            }
        }
        return flightIndex;
    }

    public boolean validateUsername(String username){
        return userService.checkUsername(username);
    }
    public boolean passwordValidator(String password1, String password2){
        return password1.equals(password2);
    }
}
