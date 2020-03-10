package ui;

public class GuestMenu implements Menu {
    @Override
    public String menuOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("|Welcome to the airport ticket booking app!  |\n");
        sb.append("|--------------------------------------------|\n");
        sb.append("|Please choose the id of operation:          |\n");
        sb.append("|                                            |\n");
        sb.append("|1. Show all flights.                        |\n");
        sb.append("|2. Show the flight info by flightNumber     |\n");
        sb.append("|3. Search a flight                          |\n");
        sb.append("|4. Exit                                     |\n");
        sb.append("|============================================|\n");
        return sb.toString();
    }
}
