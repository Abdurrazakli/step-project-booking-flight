package service;

import dao.BookingDAO;
import dao.Database;
import entity.Booking;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private Database db;
    public BookingService(Database db) {
        this.db = db;
    }

    public List<Booking> getAllBookings(String authenticatedUsername){
        return db.bookingDAO.getAll().stream().filter(booking ->
                booking.getUser().getUsername().equals(authenticatedUsername))
                .collect(Collectors.toList());
    }

    public List<Booking> getFlightsByFullName(String username, String name, String surname){
        return getAllBookings(username).stream().filter(booking ->
                booking.getPassengers().stream().anyMatch(passenger ->
                        passenger.getName().equals(name) && passenger.getSurname().equals(surname)))
                .collect(Collectors.toList());
    }

    public boolean bookAFlight(Booking booking){
        return db.bookingDAO.create(booking);
    }
    public int getNextID(){
        List<Booking> collect = db.bookingDAO.getAll()
                .stream()
                .sorted((a, b) -> b.getID() - a.getID())
                .collect(Collectors.toList());
        return collect.isEmpty() ? 100000 : collect.get(0).getID()+1;
    }

    public boolean cancelBooking(int bookingID){
        return db.bookingDAO.delete(bookingID);
    }
}
