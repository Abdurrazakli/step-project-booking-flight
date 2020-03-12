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
    }

    public List<Flight> getFlights(){
        return db.flightDAO.getAll()
                .stream()
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByParametr(String destination,int numberOfSeats, String date ){
        return db.flightDAO.getAll().stream().filter(flight -> flight.to.getName().toUpperCase().equals(destination.toUpperCase()) &&
                flight.seats>=numberOfSeats &&
                (flight.flightDate.toString().equals(date) || date.equals("")))
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }


    public List<Flight> getFlightsByFlightNumber(String flightNumber){
        return db.flightDAO.getAll().stream().filter(flight ->
                flight.flightNumber.equals(flightNumber))
                .sorted(Comparator.comparingInt(f -> f.ID))
                .collect(Collectors.toList());
    }
}
