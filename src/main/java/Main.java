import dao.Database;
import dao.FlightDAO;
import dao.UserDAO;
import entity.Booking;
import entity.Flight;
import entity.User;
import util.FlightGenerator;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Database<Flight>ff = new Database<>();
        ff.write(FlightGenerator.FLIGHT_DB_PATH,FlightGenerator.generate());
        BookingManager bookingManager = new BookingManager();
        bookingManager.run();
    }
}
