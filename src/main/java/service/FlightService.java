package service;

import dao.FlightDAO;
import entity.Flight;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightService {

    private FlightDAO flightDAO = new FlightDAO();

    public FlightService() {
    }   //

    public Flight updateSeatsOfFlight(Flight flight, int bookedSeats){
        flight.setSeats(flight.getSeats()-bookedSeats);
        flightDAO.update(flight);
        return flight;
    }



    public List<Flight> getFlights(){
        return flightDAO.getAll()
                .stream()
                .sorted(Comparator.comparingInt(Flight::getID))
                .filter(flight -> {
                    Period day = Period.between(LocalDate.now(),flight.getFlightDate());
                    return day.getDays() == 1;
                })
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByParametr(String destination,int numberOfSeats, String date ){
        return getFlights().stream().filter(flight -> flight.getTo().getName().toUpperCase().equals(destination.toUpperCase()) &&
                flight.getSeats()>=numberOfSeats &&
                (flight.getFlightDate().toString().equals(date) || date.equals("")))
                .sorted(Comparator.comparingInt(Flight::getID))
                .collect(Collectors.toList());
    }


    public List<Flight> getFlightsByFlightNumber(String flightNumber){
        return flightDAO.getAll().stream().filter(flight ->
                flight.getFlightNumber().equals(flightNumber))
                .sorted(Comparator.comparingInt(Flight::getID))
                .collect(Collectors.toList());
    }
}
