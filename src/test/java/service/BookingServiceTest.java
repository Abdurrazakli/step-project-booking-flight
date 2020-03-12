package service;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    List<Booking> bookings;
    @BeforeEach
    void init(){
        Flight f = new Flight(12,"THY358", Airport.ATL,Airport.AGD,100,10,LocalDate.now());
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("p1name","p1surname"));
        User user = new User("uname","u")
        Booking b1 = new Booking(1,f,passengers,)
    }

    @Test
    void getAllBookings() {

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