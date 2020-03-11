import dao.Database;
import dao.UserDAO;
import entity.Booking;
import entity.Flight;
import entity.User;
import util.FlightGenerator;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        bookingManager.run();
    }
}
