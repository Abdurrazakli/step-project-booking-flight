package service;

import dao.BookingDAO;
import dao.FlightDAO;
import dao.UserDAO;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private List<Booking> bookings;
    private User user;
    private Flight flight;
    private Passenger passenger;
    private Booking booking;
    private BookingDAO bookingDAO;
    private FlightDAO flightDAO;
    private UserDAO userDAO;
    private List<Passenger> passengers;
    private static BookingService bookingService;
    @BeforeEach
    void init(){
        bookingDAO = new BookingDAO();
        flightDAO = new FlightDAO();
        userDAO = new UserDAO();
        flight = new Flight(12,"THY358", Airport.ATL,Airport.AGD,100,10,LocalDate.now());
        passengers = new ArrayList<>();
        bookings = new ArrayList<>();
        passenger = new Passenger("p1name","p1surname");
        passengers.add(passenger);
        user =  new User("TestName","TestSurname",Long.toString(System.currentTimeMillis()),"123456");
        booking = new Booking(1, flight,user,passengers,LocalDate.now());
        bookings.add(booking);
        bookingService = new BookingService();
        //writing to database
        bookingDAO.create(booking);
    }
    @AfterEach
    void delete(){
        flightDAO.delete(flight.getID());
        bookingDAO.getAll().forEach(s-> bookingDAO.delete(s.getID()));
        userDAO.delete(user.getID());
    }
    @Test
    void getAllBookings() {
        assertEquals(bookings,bookingService.getAllBookings(user.getUsername()),"Bookings are not same");
    }

    @Test
    void getFlightsByFullName() {
        assertEquals(bookings,bookingService.getFlightsByFullName(user.getUsername(),passenger.getName(),passenger.getSurname()),
                "Searched Flights by full name don't match");
    }


    @Test
    void bookAFlight() {
        Booking newBook = new Booking((int) System.currentTimeMillis(), flight,user,passengers,LocalDate.now());
        boolean result = bookingService.bookAFlight(newBook);
        bookings = bookingService.getAllBookings(user.getUsername());
        assertTrue(bookings.contains(newBook),"Book a flight doesn't work");
        bookingService.cancelBooking(newBook.getID());
    }

    @Test
    void getNextID() {
        Booking newBook = new Booking(Integer.MAX_VALUE-1,
                flight,user,passengers,LocalDate.now());
        bookingService.bookAFlight(newBook);
        assertEquals(Integer.MAX_VALUE,bookingService.getNextID(),"Next id doesn't work in a right way");
        bookingService.cancelBooking(newBook.getID());
    }

    @Test
    void cancelBooking() {
        bookingService.cancelBooking(booking.getID());
        assertFalse(bookingService.getAllBookings(user.getUsername()).contains(booking),
                "Cancel booking doesn't work");
    }
}