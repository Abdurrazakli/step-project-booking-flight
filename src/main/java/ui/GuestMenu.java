package ui;

public class GuestMenu implements Menu {
    @Override
    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append("|============================================|\n");
        sb.append("|Welcome to the airport ticket booking app!  |\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("\n");
        return sb.toString();
    }
}
