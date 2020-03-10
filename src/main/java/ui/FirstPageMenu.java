package ui;

public class FirstPageMenu implements Menu {

    @Override
    public String menuOptions() {
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
}
