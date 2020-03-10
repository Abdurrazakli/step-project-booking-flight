package service;

import dao.UserDAO;
import entity.User;

public class RegisterService {
    private UserDAO userDAO = new UserDAO();
    private UserService userService = new UserService();

    public boolean register(User newUser){
        User.setIdCounter(userDAO.getAll().isPresent()?userDAO.getAll().get().size():1);//TODO:Fix me
        return !userService.checkUsername(newUser) && userDAO.create(newUser);
    }
}
