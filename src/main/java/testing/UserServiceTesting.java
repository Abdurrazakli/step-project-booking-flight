package testing;

import dao.UserDAO;
import entity.User;
import service.UserService;

public class UserServiceTesting {
    public static void main(String[] args) {
        User user = new User("a","soy","uname","parol");
        UserDAO dao = new UserDAO();
        UserService userService = new UserService();
        dao.create(user);
        System.out.println(userService.checkUsername(user.username));
    }
}
