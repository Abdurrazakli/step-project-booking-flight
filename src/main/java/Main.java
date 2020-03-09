import dao.Database;
import entity.User;
import util.FlightGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightGenerator fg = new FlightGenerator();
//        FlightGenerator.generate().forEach(System.out::println);
//
        UserDAO userDAO = new UserDAO();
        Boolean aBoolean = userDAO.create(new User("Afgan", "Mustafayev", "emustafayev", "efqan123"));
        System.out.println(aBoolean);
        List<User> users = userDAO.getAll().get();
        System.out.println(users);
        Database<Flight> db = new Database<>();
        db.init();


    }
}
