package service;

import dao.UserDAO;
import entity.User;

public class UserService {
    public UserDAO userDAO = new UserDAO();

    public boolean checkUsername(User newUser){
        return userDAO.getAll().flatMap(users ->
                users.stream().filter(user ->
                        user.equals(newUser)).findAny())
                        .isPresent();
    }
    public boolean register(User user){
        //validation method, checkUsername ==>>true?create in db:return false;
        throw new IllegalArgumentException("Not impl yet");
    }

    public boolean login(User user){
        // checkUsername=>true?true(new Session):false
        throw new IllegalArgumentException("Not impl yet");
    }
    public void logout(){
        // what to do???
        throw new IllegalArgumentException("Not impl yet");
    }
}
