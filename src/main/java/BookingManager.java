import Controller.*;
import dao.Database;
import entity.Flight;
import ui.*;
import util.FlightGenerator;
import util.TerminateProgram;

public class BookingManager {
    private final BookingController bookingController = new BookingController();
    private GuestController guest = new GuestController();
    private RegisterController register = new RegisterController();
    private LoginController login = new LoginController();
    private final Console console = new Console();
    private TerminateProgram terminator = new TerminateProgram();
    Database<Flight> db = new Database<>();
    int choice;
    public void run(){
        db.__init__();
        while(true) {
                console.print(Messages.showFirsPageMenu());
                int choice = Integer.parseInt(console.readLine());
                switch (choice){//guest,register,login,exit
                    case 1:
                        guest.start();
                        break;
                    case 2:
                        register.register();
                        break;
                    case 3:
                        login.login();
                        break;
                    case 4:
                        terminator.terminate();
                        break;
                    default:
                        console.print("Please enter a valid operation id!");
                }
            }


        }

}