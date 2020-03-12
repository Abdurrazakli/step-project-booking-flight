package dao;

import entity.Flight;
import util.FlightGenerator;

public class Database {
    public UserDAO userDAO;
    public FlightDAO flightDAO;
    public BookingDAO bookingDAO;
    private String USER_DB_PATH = "./data/users.bin";
    private String FLIGHT_DB_PATH = "./data/flights.bin";
    private String BOOKING_DB_PATH = "./data/bookings.bin";
    public void __init__(){
        FileOperations<Flight> db = new FileOperations<>();
        db.write(FlightGenerator.FLIGHT_DB_PATH,FlightGenerator.generate());
        userDAO = new UserDAO(USER_DB_PATH);
        flightDAO = new FlightDAO(FLIGHT_DB_PATH);
        bookingDAO = new BookingDAO(BOOKING_DB_PATH);
    }
}
