package service;

import dao.FlightDAO;
import entity.Airport;
import entity.Flight;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightService {

    FlightDAO flightDAO = new FlightDAO();

    public List<Flight> getFlights(){
        return flightDAO.getAll()
                .stream()
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByParametr(String destination,int numberOfSeats, String date ){
        return flightDAO.getAll().stream().filter(flight -> flight.to.getName().toUpperCase().equals(destination.toUpperCase()) &&
                flight.seats>=numberOfSeats &&
                (flight.flightDate.toString().equals(date) || date.equals("")))
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }


    public List<Flight> getFlightsByFlightNumber(String flightNumber){
        return flightDAO.getAll().stream().filter(flight ->
                flight.flightNumber.equals(flightNumber))
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }

}
