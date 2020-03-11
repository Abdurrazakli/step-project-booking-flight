package Controller;

import ui.Console;
import ui.Messages;

public class GuestController {
    Console console = new Console();
    public void start(){
        console.print(Messages.showGuestMenu());

        throw new IllegalArgumentException("GuestControllerStart implement!");
    }
}
