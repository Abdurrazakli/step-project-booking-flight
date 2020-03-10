package service;

import dao.FlightDAO;
import entity.Airport;
import entity.Flight;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightService {

    FlightDAO flightDAO = new FlightDAO();

    public List<Flight> getFlights(){
        return flightDAO.getAll();
    }

    public List<Flight> getFlightsByParametr(Airport destination,int numberOfSeats, int dayOfMonth ){
        Predicate<Flight>  p1 = flight -> flight.to == destination;
        Predicate<Flight> finalPred = p1.and(flight -> flight.seats >= numberOfSeats).and(flight -> flight.startDate.getDayOfMonth() == dayOfMonth);
        return getFlights().stream().filter(finalPred).collect(Collectors.toList());
    }

}
