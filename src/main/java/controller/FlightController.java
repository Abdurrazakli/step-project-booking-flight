package controller;

import dao.Database;
import entity.Flight;
import service.FlightService;
import ui.Console;
import util.Parser;

import java.util.List;

public class FlightController {
    private Console console;
    private Database db;
    private FlightService flightService;


    public FlightController(Console console, Database db) {
        this.console = console;
        this.db = db;
        flightService = new FlightService(db);
    }


    public void showAllFlights(){
        console.print("=============All Flights==============");
        flightService
                .getFlights()
                .forEach(f->console.print(String.format("%d. %s",f.getID(),f.toString())));
    }
    public void showAllFlightByFlightNumber(String FN){
        List<Flight> filtered = flightService.getFlightsByFlightNumber(FN.toUpperCase());
        if(filtered.size() == 0){
            console.print("There is not such a flight.\nMake sure it is valid FN");
        }else {
            console.print("==============Flights============");
            filtered.forEach(f->console.print(String.format("%d. %s",f.getID(),f.toString())));
        }
    }
    public void showSearchedFlight(List<Flight> filtered){
        if(filtered.size() == 0){
            console.print("There is not such a flight.\n");
        }else {
            console.print("==============Flights============");
            filtered.forEach(f->console.print(String.format("%d. %s",f.getID(),f.toString())));
        }
    }
    public List<Flight> searchFlights(){
        String destination;
        int seats;
        String date;
        console.print("Please enter the destination:");
        destination = console.readLine();
        console.print("Please enter the number of seats:");
        seats = Parser.getUserChoice(console);
        console.print("Please enter the date:(year-day-month ex:2020-15-03). You can leave empty(just press enter!)");
        date = console.readLine();
        return flightService.getFlightsByParametr(destination,seats,date);
    }

}
