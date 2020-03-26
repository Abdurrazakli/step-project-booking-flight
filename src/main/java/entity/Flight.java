package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Flight implements Serializable {
    private final int ID;
    private final String flightNumber;
    private final Airport from;
    private final Airport to;
    private final int price;
    private int seats;
    private final LocalDate flightDate;

    public Flight(int id, String flightNumber, Airport from, Airport to, int price, int seats, LocalDate startDate) {
        this.ID = id;
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seats = seats;
        this.flightDate = startDate;
    }

    public int getID() {
        return ID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    private String represent(){
        return String.format("%s %s-->%s %8dAZN %4d %4s", flightNumber, from.getName(), to.getName(), price, seats, flightDate);
    }
    @Override
    public String toString() {
        return String.format("Flight: [%s]",represent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return  seats == flight.seats &&
                flightNumber.equals(flight.flightNumber) &&
                flightDate.equals(flight.flightDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, from, to, price, seats, flightDate);
    }
}
