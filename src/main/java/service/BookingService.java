package service;

import dao.BookingDAO;
import dao.Database;
import entity.Booking;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private Database db;
    public BookingService(Database db) {
        this.db = db;
    }

    public List<Booking> getAllBookings(String authenticatedUsername){
        return db.bookingDAO.getAll().stream().filter(booking ->
                booking.user.username.equals(authenticatedUsername))
                .collect(Collectors.toList());
    }

    public List<Booking> getFlightsByFullName(String username, String name, String surname){
        return getAllBookings(username).stream().filter(booking ->
                booking.passengers.stream().anyMatch(passenger ->
                        passenger.name.equals(name) && passenger.surname.equals(surname)))
                .collect(Collectors.toList());
    }

    public boolean bookAFlight(Booking booking){
        return db.bookingDAO.create(booking);
    }

    public boolean cancelBooking(int bookingID){
        return db.bookingDAO.delete(bookingID);
    }
}
