package Controller;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;
import service.BookingService;
import service.FlightService;
import ui.Console;
import util.Parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookingController {
    Parser parser = new Parser();
    Console console = new Console();
    BookingService bookingService = new BookingService();
    FlightService flightService = new FlightService();
    FlightController flightController = new FlightController();
    int seatCount;
    String passengerName, passengerSurname;
    List<Passenger> passengerList = Collections.emptyList();


    public void bookAFlight(User LoggedInUser){
        List<Flight> flightsByFlightNumber;
        flightController.showAllFlights();
        console.print("Enter flight Code: ");
        while (true){
            String flightCode = console.readLine();

            flightsByFlightNumber = flightService.getFlightsByFlightNumber(flightCode);
            if (flightsByFlightNumber.size()==0){
                console.print("Can not find flight according to entered flight number!");
            }else {
                break;
            }
        }
        console.print("How many ticket you will buy? ");

        while (true){
            String s = console.readLine();
            if(parser.strToInt(s).isPresent()){
                seatCount =parser.strToInt(s).get();
                while(true){
                    if(flightsByFlightNumber.get(0).seats>=seatCount){
                        console.print("Enter passenger name: ");
                        passengerName = console.readLine();
                        console.print("Enter passenger surname");
                        passengerSurname = console.readLine();
                        passengerList.add(new Passenger(passengerName,passengerSurname));//TODO Exception in thread "main" java.lang.UnsupportedOperationException
                    }else{
                        break;
                    }
                }
                break;
                }else {
                console.print("Please enter an integer");
            }

        }
        bookingService.bookAFlight(new Booking(flightsByFlightNumber.get(0),LoggedInUser,passengerList, LocalDate.now()));
    }
}
