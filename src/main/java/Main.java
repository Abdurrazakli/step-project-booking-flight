import dao.FileOperations;
import entity.Flight;
import util.FlightGenerator;

public class Main {
    public static void main(String[] args) {
        FileOperations<Flight> ff = new FileOperations<>();
        ff.write(FlightGenerator.FLIGHT_DB_PATH,FlightGenerator.generate());
        BookingManager bookingManager = new BookingManager();
        bookingManager.run();
    }
}
