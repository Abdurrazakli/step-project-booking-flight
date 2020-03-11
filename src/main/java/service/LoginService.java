package service;

import entity.User;
import java.util.Optional;

public class LoginService {
    private UserService userService = new UserService();
    /*
        todo login boolean qaytarsin.
     Loginle bagli butun prosedurlar bu loginin icinde bas versin
     message gostermek
     menyu secimlerini etmek
     onlara uygun lazimi servisleri cagirmaq
     */
    public Optional<User> login(String username, String password){
        return userService.checkUsernameAndPassword(username,password);
    }
}
