package service;

import dao.Database;
import dao.FlightDAO;
import entity.Flight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private Database db;
    public FlightService(Database db) {
        this.db = db;
    }   //

    public List<Flight> getFlights(){
        return db.flightDAO.getAll()
                .stream()
                .sorted(Comparator.comparingInt(f -> f.getID()))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByParametr(String destination,int numberOfSeats, String date ){
        return db.flightDAO.getAll().stream().filter(flight -> flight.getTo().getName().toUpperCase().equals(destination.toUpperCase()) &&
                flight.getSeats()>=numberOfSeats &&
                (flight.getFlightDate().toString().equals(date) || date.equals("")))
                .sorted(Comparator.comparingInt(f -> f.getID()))
                .collect(Collectors.toList());
    }


    public List<Flight> getFlightsByFlightNumber(String flightNumber){
        return db.flightDAO.getAll().stream().filter(flight ->
                flight.getFlightNumber().equals(flightNumber))
                .sorted(Comparator.comparingInt(f -> f.getID()))
                .collect(Collectors.toList());
    }
}
