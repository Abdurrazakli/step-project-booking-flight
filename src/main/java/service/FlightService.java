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
       return getFlights().stream().filter(flight -> flight.to==destination)
               .filter(flight -> flight.seats>=numberOfSeats)
               .filter(flight -> flight.startDate.getDayOfMonth()==dayOfMonth).collect(Collectors.toList());
    }
    public List<Flight> getFlightsByFlightNumber(String flightNumber){
        //todo FN service
        throw new IllegalArgumentException("Service getFlight by FN Implement");
    }

}
