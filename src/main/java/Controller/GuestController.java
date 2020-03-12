package Controller;


import exceptions.InvalidInput;
import service.FlightService;
import ui.Console;
import ui.Messages;
import util.TerminateProgram;

public class GuestController {
    private FlightService flightService = new FlightService();
    private FlightController flightController = new FlightController();
    private TerminateProgram terminator = new TerminateProgram();
    private Console console = new Console();
    public void start(){
        int choice = 0;
        int operations_count = 4;
        while (true) {
            boolean LOG_OUT=false;

            try{
                console.print(Messages.showGuestMenu());
                choice = Integer.parseInt(console.readLine());
                if(choice > operations_count || choice < 0){
                    throw new InvalidInput("Invalid input of user");
                }
                else {
                    switch (choice){
                        case 1:
                            flightController.showAllFlights();
                        break;
                        case 2:
                            console.print("\nPlease enter flight number:(ex THY358)");
                            flightController.showAllFlightByFlightNumber(console.readLine());
                            break;
                        case 3:
                            flightController.showSearchedFlight(flightController.searchFlights());
                            break;
                        case 4:
                            LOG_OUT=true;
                            break;
                        case 5:
                            terminator.terminate();
                            break;
                        default:break;
                    }
                }
            }
            catch (NumberFormatException ex){
                    console.print("Only numbers");
            }
            catch (InvalidInput ex){
                console.print(ex.getMessage());
            }
            if(LOG_OUT){
                break;
            }
        }
    }

}
