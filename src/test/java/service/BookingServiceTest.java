package service;

import dao.Database;
import entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private List<Booking> bookings;
    private User user;
    private static Database database;
    private Flight flight;
    private Passenger passenger;
    private Booking booking;
    private static BookingService bookingService;
    @BeforeEach
    void init(){
        flight = new Flight(12,"THY358", Airport.ATL,Airport.AGD,100,10,LocalDate.now());
        List<Passenger> passengers = new ArrayList<>();
        bookings = new ArrayList<>();
        passenger = new Passenger("p1name","p1surname");
        passengers.add(passenger);
        user = new User("TestName","TestSurname",Long.toString(System.currentTimeMillis()),"123456");
        booking = new Booking(1, flight,user,passengers,LocalDate.now());
        bookings.add(booking);
        database = new Database();
        bookingService = new BookingService(database);
        //writing to database
        database.bookingDAO.create(booking);
    }
    @AfterEach
    void delete(){
        database.flightDAO.delete(flight.getID());
        database.bookingDAO.delete(booking.getID());
        database.userDAO.delete(user.getID());
    }
    @Test
    void getAllBookings() {
        assertEquals(bookings,bookingService.getAllBookings(user.getUsername()),"Bookings are not same");
    }

    @Test
    void getFlightsByFullName() {
    }

    @Test
    void bookAFlight() {
    }

    @Test
    void getNextID() {
    }

    @Test
    void cancelBooking() {
    }
}