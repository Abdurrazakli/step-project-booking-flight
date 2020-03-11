package service;

import dao.BookingDAO;
import entity.Booking;

import java.util.List;

public class BookingService {
    private BookingDAO dao = new BookingDAO();
    public List<Booking> getAllBookings(){
        return dao.getAll();
    }

    public List<Booking> getFlightsByFullName(String name, String surname){
        //todo booking by full name service
        //Should return booked flights by full name or this full name is passenger of that flight
        throw new IllegalArgumentException("Booking full name implement!");
    }
    public boolean bookAFlight(Booking booking){
        //todo book a flight service
        throw new IllegalArgumentException("booking made implement");
    }
    public boolean cancelBooking(Booking booked){
        //todo delete specified booking service
        throw new IllegalArgumentException("cancel booking implement");
    }
}
