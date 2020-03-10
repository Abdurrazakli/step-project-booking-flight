package service;

import dao.UserDAO;
import entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegisterService {
    private UserDAO userDAO = new UserDAO();
    private UserService userService = new UserService();

    public boolean register(User newUser){
        List<User> users = userDAO.getAll().stream().sorted((a, b) -> a.ID - b.ID).collect(Collectors.toList());
        int id = users.size() == 0 ? 1 : users.get(users.size() - 1).ID + 1;
        User.setIdCounter(id);//TODO:Fix me
        return !userService.checkUsername(newUser) && userDAO.create(newUser);
    }
}
