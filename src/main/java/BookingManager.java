import controller.*;
import dao.Database;
import ui.*;
import util.FlightGenerator;
import util.Parser;
import util.TerminateProgram;

public class BookingManager {
    private RegisterController register;
    private LoginController login;
    private TerminateProgram terminator;
    private Database db;
    private Console console;
    private GuestController guest;

    public BookingManager(){
        console = new Console();
        db = new Database();
        register = new RegisterController(console,db);
        login = new LoginController(console,db);
        terminator = new TerminateProgram();//TODO added features; &&& Make terminate static;
        guest = new GuestController(console,db);
        FlightGenerator.generation(db);

    }

    public void run(){
        while(true) {
                console.print(Messages.showFirsPageMenu());
                int choice = Parser.getUserChoice(console);
                switch (choice){
                    case 1:
                        guest.start();
                        break;
                    case 2:
                        register.register();//console,
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