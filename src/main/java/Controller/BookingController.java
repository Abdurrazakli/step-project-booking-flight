package Controller;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;
import exceptions.InvalidInput;
import exceptions.OutOfBound;
import service.BookingService;
import service.FlightService;
import ui.Console;
import util.NumberCheck;
import util.Parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    Parser parser = new Parser();
    Console console = new Console();
    BookingService bookingService = new BookingService();
    FlightService flightService = new FlightService();
    FlightController flightController = new FlightController();
    int seatCount;
    String passengerName, passengerSurname;
    List<Passenger> passengers;
    List<Flight> flights;

    public void bookMe(User user) {
        String destination;
        int seats;
        String date;
        console.print("Please enter the destination:");
        destination = console.readLine();
        console.print("Please enter the number of seats:");
        seats = NumberCheck.getNumber(console.readLine());
        console.print("Please enter the date:(year-day-month ex:2020-15-03");
        date = console.readLine();
        flights = flightService.getFlightsByParametr(destination, seats, date);
        flightController.showSearchedFlight(flights);
        if (flights.size() > 0) {
            console.print("Enter flight index: ");
            int flightId = NumberCheck.getNumber(console.readLine());
            for (int i = 1; i <= seats; i++) {
                console.print(String.format("Name of the %d. passenger:", i));
                passengerName = console.readLine();
                console.print(String.format("Surname of the %d. passenger:", i));
                passengerSurname = console.readLine();
                passengers.add(new Passenger(passengerName, passengerSurname));
            }
            Flight flight = flights.stream().filter(f -> f.ID == flightId).collect(Collectors.toList()).get(0);
            Booking booking = new Booking(flight, user, passengers, LocalDate.now());
            if (bookingService.bookAFlight(booking)) {
                console.print("Succesfully booked");
                console.print(booking.toString());
            }

        }
    }

    private int getFlightId() {
        try {
            int id = Integer.parseInt(console.readLine());
            if (id > flights.get(flights.size() - 1).ID) {
                throw new OutOfBound("Entered id is not valid");
            }
            return id;
        } catch (NumberFormatException ex) {
            console.print("Invalid id\nEnter again:");
            return getFlightId();
        } catch (OutOfBound ex) {
            console.print(String.format("%s\nEnter again", ex.getMessage()));
            return getFlightId();
        }
    }
}
