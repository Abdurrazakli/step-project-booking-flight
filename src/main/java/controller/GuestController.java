package controller;


import dao.Database;
import exceptions.InvalidInput;
import ui.Console;
import ui.Messages;
import util.Parser;
import util.TerminateProgram;

public class GuestController {

    private TerminateProgram terminator = new TerminateProgram();
    private Console console;
    private Database db;
    private FlightController flightController;

    public GuestController(Console console, Database db) {
        this.console = console;
        this.db = db;
        flightController = new FlightController(console, db);
    }

    public void start(){
        int choice = 0;
        while (true) {
            boolean LOG_OUT=false;

                console.print(Messages.showGuestMenu());
                choice = Parser.getUserChoice(console);
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
                        default:console.print("Invalid Operation ID!");break;
                    }
                    if(LOG_OUT){
                        break;
                    }
                }
            }
        }

