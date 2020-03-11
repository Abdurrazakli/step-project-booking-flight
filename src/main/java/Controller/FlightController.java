package Controller;

import service.FlightService;
import ui.Console;

public class FlightController {
    private FlightService flightService = new FlightService();
    private Console console = new Console();
    public void showAllFlights(){
        console.print("=============All Flights==============");
        flightService
                .getFlights()
                .stream().
                forEach(f->console.print(f.toString()));
    }
}
