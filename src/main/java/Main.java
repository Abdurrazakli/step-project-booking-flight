import dao.Database;
import dao.UserDAO;
import entity.Flight;
import entity.User;
import util.FlightGenerator;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        FlightGenerator fg = new FlightGenerator();
//        FlightGenerator.generate().forEach(System.out::println);
//
        UserDAO userDAO = new UserDAO();
        Database<Flight> db = new Database<>();
        Boolean aBoolean2 = userDAO.create(new User("ddwdfewfwefwe", "Mustafayev", "emustafayev", "efqan123"));
        List<User> users = userDAO.getAll().get();
        System.out.println(users);

        db.init();
    }
}
