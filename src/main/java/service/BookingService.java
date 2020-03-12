package service;

import dao.BookingDAO;
import entity.Booking;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDAO bookingDAO = new BookingDAO();
    public List<Booking> getAllBookings(String authenticatedUsername){
        return bookingDAO.getAll().stream().filter(booking ->
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
        return bookingDAO.create(booking);
    }

    public boolean cancelBooking(int bookingID){
        return bookingDAO.delete(bookingID);
    }
}
