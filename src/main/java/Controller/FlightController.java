package Controller;

import entity.Flight;
import service.FlightService;
import ui.Console;
import util.NumberCheck;

import java.util.Comparator;
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
                .forEach(f->console.print(String.format("%d. %s",f.ID,f.toString())));
    }
    public void showAllFlightByFlightNumber(String FN){
        List<Flight> filtered = flightService.getFlightsByFlightNumber(FN.toUpperCase());
        if(filtered.size() == 0){
            console.print("There is not such a flight.\nMake sure it is valid FN");
        }else {
            console.print("==============Flights============");
            filtered.forEach(f->console.print(String.format("%d. %s",f.ID,f.toString())));
        }
    }
    public void showSearchedFlight(List<Flight> filtered){
        if(filtered.size() == 0){
            console.print("There is not such a flight.\n");
        }else {
            console.print("==============Flights============");
            filtered.stream().forEach(f->console.print(String.format("%d. %s",f.ID,f.toString())));
        }
    }
    public List<Flight> searchFlights(){
        String destination;
        int seats;
        String date;
        console.print("Please enter the destination:");
        destination = console.readLine();
        console.print("Please enter the number of seats:");
        seats = NumberCheck.getNumber(console.readLine());
        console.print("Please enter the date:(year-day-month ex:2020-15-03");
        date = console.readLine();
        return flightService.getFlightsByParametr(destination,seats,date);
    }

}
