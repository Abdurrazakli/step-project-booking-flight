package service;

import dao.BookingDAO;
import dao.Database;
import dao.FlightDAO;
import dao.UserDAO;
import entity.Airport;
import entity.Booking;
import entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {

    private FlightService flightService;
    private List<Flight> flights;
    private Booking booking;
    private BookingDAO bookingDAO;
    private FlightDAO flightDAO;
    private UserDAO userDAO;

    @BeforeEach
    void _init_(){
        bookingDAO = new BookingDAO();
        flightDAO = new FlightDAO();
        userDAO = new UserDAO();
        Flight flight = new Flight(1,"BUT253", Airport.AGD,Airport.DXB,500,100, LocalDate.parse("2020-03-20"));
        flights = new ArrayList<>();
        flights.add(flight);

        FlightDAO.FLIGHT_DB_PATH =  "./data/testFlights.bin";
        Database db = new Database();
        flightService = new FlightService();
        flightDAO.create(flight);
    }

    @Test
    void getFlightsTest() {
        List<Flight> flightsActual = flightService.getFlights();
        assertEquals(flights,flightsActual,"Flights did not match!");
    }

    @Test
    void getFlightsByParametrTest() {
        String destination = "Dubai";
        int numberOfSeats = 5;
        String date = "";
        assertEquals(flights,flightService.getFlightsByParametr(destination, numberOfSeats, date),"Flights did not match!");
    }

    @Test
    void getFlightsByFlightNumberTest() {
        String flightNumber = "BUT253";
        assertEquals(flights,flightService.getFlightsByFlightNumber(flightNumber),"Flights did not match!");
    }
}
