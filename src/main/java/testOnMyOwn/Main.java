package testOnMyOwn;

import dao.Database;
import entity.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Adil","Abdurrazakli","abd11","1234");
        String flighNumber = Airline.AZAL.getAirlineCode()+"758";
        ZonedDateTime time = ZonedDateTime.now(ZoneId.systemDefault());
        Flight flight = new Flight(flighNumber, Airport.ATL,Airport.CWC,100,50, ZonedDateTime.now(ZoneId.systemDefault()));
        System.out.println(user);
        System.out.println(flight);
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Adil","a"));
        passengers.add(new Passenger("b","b"));
        passengers.add(new Passenger("c","c"));
        passengers.add(new Passenger("d","d"));
        Booking booked = new Booking(flight,user,passengers,time);
        System.out.println(booked);
        Database<User> userDatabase = new Database<>();
        List<User> users = new ArrayList<>();
        users.add(user);
        userDatabase.write("src/main/java/testOnMyOwn/a.bin", users);
        System.out.println(userDatabase.read("src/main/java/testOnMyOwn/a.bin"));
        UserDAO dao = new UserDAO();
        dao.getAll().get().stream().forEach(us-> System.out.println(us));
    }
}
