/**
 * It keeps enums and their string meaning for easy  switch case usage
 * */

package util;

public enum Actions {
    GUEST("Continue as a guest(limited usage)"),
    REGISTER("Register"),
    LOGIN("Login"),
    SHOW_ALL_FLIGHTS("Show all flights"),
    FLIGHT_BY_NUMBER("Show the flight info by flightNumber"),
    SEARCH_FLIGHTS("Search a flight"),
    BOOK("Book a flight"),
    CANCEL_BOOKING("Cancel booking"),
    MY_FLIGHTS("My flights"),
    EXIT("Exit");
    private final String description;
    Actions(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
