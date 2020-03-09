package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    public final String flightNumber;
    public final Airport from;
    public final Airport destination;
    public final int price;
    public final int seats;
    public final LocalDateTime startDate;

    public Flight(String flightNumber, Airport from, Airport destination, int price, int seats, LocalDateTime startDate) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.destination = destination;
        this.price = price;
        this.seats = seats;
        this.startDate = startDate;
    }

//    private String represent(){
//
//    }
//    @Override
//    public String toString() {
//        return String.format("Flight",);
//    }

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
        return Objects.hash(flightNumber, from, destination, price, seats, startDate);
    }
}
