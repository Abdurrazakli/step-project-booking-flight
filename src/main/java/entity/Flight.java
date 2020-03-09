package entity;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Flight {
    public final int ID;
    public final String flightNumber;
    public final Airport from;
    public final Airport to;
    public final int price;
    public final int seats;
    public final ZonedDateTime startDate;

    public Flight(int id, String flightNumber, Airport from, Airport to, int price, int seats, ZonedDateTime startDate) {
        this.ID = id;
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seats = seats;
        this.startDate = startDate;
    }

    private String represent(){
        return String.format("%s %s %s %d %d %s", flightNumber, from, to, price, seats, startDate);
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
                startDate.equals(flight.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, from, to, price, seats, startDate);
    }
}
