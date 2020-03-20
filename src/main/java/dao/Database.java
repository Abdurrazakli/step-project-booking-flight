package dao;

import entity.Flight;
import util.FlightGenerator;

public class Database {
    public UserDAO userDAO;
    public FlightDAO flightDAO;
    public BookingDAO bookingDAO;
    public static String USER_DB_PATH = "./data/users.bin";
    public static String FLIGHT_DB_PATH = "./data/flights.bin";
    public static String BOOKING_DB_PATH = "./data/bookings.bin";

    public Database (){
        userDAO = new UserDAO(USER_DB_PATH);
        flightDAO = new FlightDAO(FLIGHT_DB_PATH);
        bookingDAO = new BookingDAO(BOOKING_DB_PATH);
    }
}
