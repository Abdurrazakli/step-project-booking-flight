package ui;

public class Messages {
    public static String showGuestMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("|Welcome to the airport ticket booking app!  |\n");
        sb.append("|--------------------------------------------|\n");
        sb.append("|Please choose the id of operation:          |\n");
        sb.append("|                                            |\n");
        sb.append("|1. Show all flights                         |\n");
        sb.append("|2. Show the flight info by flightNumber     |\n");
        sb.append("|3. Search a flight                          |\n");
        sb.append("|4. Back To Main Menu                        |\n");
        sb.append("|5. Exit                                     |\n");
        sb.append("|============================================|\n");
        return sb.toString();
    }
    public static String showFirsPageMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("|Welcome to the airport ticket booking app!  |\n");
        sb.append("|--------------------------------------------|\n");
        sb.append("|Please choose the id of operation:          |\n");
        sb.append("|                                            |\n");
        sb.append("|1. Continue as a guest(limited usage)       |\n");
        sb.append("|2. Register                                 |\n");
        sb.append("|3. Login                                    |\n");
        sb.append("|4. Exit                                     |\n");
        sb.append("|============================================|\n");
        return sb.toString();
    }
    public static String showLoggedUserMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("|Welcome to the airport ticket booking app!  |\n");
        sb.append("|--------------------------------------------|\n");
        sb.append("|Please choose the id of operation:          |\n");
        sb.append("|                                            |\n");
        sb.append("|1. Show all flights                         |\n");
        sb.append("|2. Show the flight info by flightNumber     |\n");
        sb.append("|3. Search a flight                          |\n");
        sb.append("|4. Book a flight                            |\n");
        sb.append("|5. Cancel booking                           |\n");
        sb.append("|6. My flights                               |\n");
        sb.append("|7. Log Out                                  |\n");
        sb.append("|8. Exit                                     |\n");
        sb.append("|============================================|\n");
        return sb.toString();
    }
}
