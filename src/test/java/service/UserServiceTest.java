package service;

import dao.UserDAO;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private User user;
    private UserService userService;
    private UserDAO userDAO;
    @BeforeEach
    void init(){
        userDAO = new UserDAO();
        user =  new User((int) System.currentTimeMillis(),"TestName","TestSurname",Long.toString(System.currentTimeMillis()),"123456");
        userDAO.create(user);
        userService = new UserService();
    }
    @AfterEach
    void delete(){
        userDAO.delete(user.getID());
    }
    @Test
    void checkUsernameIfItExistReturnTrue() {
       assertTrue(userService.checkUsername(user.getUsername()),
               "A username can be created for the second time");
    }
    @Test
    void checkUsernameIfItNotExistReturnFalse() {
        assertFalse(userService.checkUsername("sdgsdgdbjashkahsjkhajkfhfhajkfhjkahjfhjfhkhfakjfhj"),
                "Non existed username is found in system as existed one");
    }

    @Test
    void createNewUser() {
        User newUser = new User((int) System.currentTimeMillis(),"Apple","PineApple",Long.toString(System.currentTimeMillis()),"123456");

        userService.createNewUser(newUser);
        assertEquals(newUser,userDAO.get(newUser.getID()).get(),"User couldn't created");
    }

    @Test
    void getValidatedUserIfUserExists() {
        Optional<User> validatedUser = userService.getValidatedUser(user.getUsername(), user.getPassword());
        assertEquals(user,validatedUser.get(),"User should be valid, but it couldn't found");
    }
    @Test
    void getValidatedUserIfUserNotExists() {
        Optional<User> validatedUser = userService.getValidatedUser("user.getUsername(),", "user.getPassword()");
        assertEquals(Optional.empty(),validatedUser,"System shouldn't contain such user");
    }
}