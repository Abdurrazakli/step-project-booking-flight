package Controller;

import entity.Flight;
import service.FlightService;
import ui.Console;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public void showAllFlightByFlightNumber(String FN){
        List<Flight> filtered = flightService.getFlightsByFlightNumber(FN);
        if(filtered.size() == 0){
            console.print("There is not such a flight.\nMake sure it is valid FN");
        }else {
            filtered.stream().forEach(f->console.print(f.toString()));
        }
    }
}
