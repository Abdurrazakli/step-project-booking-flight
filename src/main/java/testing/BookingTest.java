package testing;

import dao.BookingDAO;
import dao.Database;
import dao.FlightDAO;
import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingTest {
    public static void main(String[] args) {
        User user = new User("Adil", "a", "a123", "1234");
        Database db = new Database();
        db.init();
        FlightDAO dao = new FlightDAO();
        List<Flight> flights = new ArrayList<>(dao.getAll());
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("a","a"));
        passengers.add(new Passenger("b","b"));
        ZonedDateTime time = ZonedDateTime.now(ZoneId.systemDefault());
        Booking booked = new Booking(flights.get(0),user,passengers,time);
        System.out.println(booked);
        BookingDAO bookingDAO = new BookingDAO();
        System.out.println(bookingDAO.create(booked));
        System.out.println(bookingDAO.getAll());

    }
}
