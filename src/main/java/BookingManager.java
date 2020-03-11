import Controller.AuthenticationController;
import Controller.BookingController;
import ui.AuthenticatedUserMenu;
import ui.FirstPageMenu;
import ui.GuestMenu;
import ui.Console;

public class BookingManager {
    private final BookingController bookingController = new BookingController();
    private final FirstPageMenu firstPage = new FirstPageMenu();
    private final GuestMenu guestMenu = new GuestMenu();
    private final AuthenticatedUserMenu authMenu = new AuthenticatedUserMenu();
    AuthenticationController authenticationController = new AuthenticationController();
    private final Console console = new Console();
    public void run(){




        while(true) {
            console.print(firstPage.menuOptions());
            authenticationController.Authentication();
            console.print(guestMenu.menuOptions());
            console.print(authMenu.menuOptions());
            break;

        }
    }
}