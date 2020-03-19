package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {
    private final int ID;
    private final Flight flight;
    private final User user;
    private final List<Passenger> passengers;
    private final LocalDate bookingDate;

    public Booking(int id, Flight flight, User user, List<Passenger> passengers, LocalDate bookingDate) {
        this.ID = id;
        this.flight = flight;
        this.user = user;
        this.passengers = passengers;
        this.bookingDate = bookingDate;
    }

    public int getID() {
        return ID;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return ID == booking.ID &&
                flight.equals(booking.flight) &&
                bookingDate.equals(booking.bookingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, flight, user, passengers, bookingDate);
    }
    private String represent(){
        return String.format("%d. FN: %s From: %s To: %s Time: %s Ordered by:%s Passengers:%s Order date:%s}",
                ID, flight.getFlightNumber(),flight.getFrom(),flight.getTo(),flight.getFlightDate(),user.getUsername(),passengers,bookingDate);
    }
    @Override
    public String toString() {
       return String.format("Booking: [%s]",represent());
           }
}
