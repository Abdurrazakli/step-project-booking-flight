package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {
    static private int bookingIdCounter = 100000;
    public final int ID;
    public final Flight flight;
    public final User user;
    public final List<Passenger> passengers;
    public final LocalDate bookingDate;

    public Booking(Flight flight, User user, List<Passenger> passengers, LocalDate bookingDate) {
        this.ID = bookingIdCounter++;
        this.flight = flight;
        this.user = user;
        this.passengers = passengers;
        this.bookingDate = bookingDate;
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
                ID, flight.flightNumber,flight.from,flight.to,flight.flightDate,user.username,passengers,bookingDate);
    }
    @Override
    public String toString() {
       return String.format("Booking: [%s]",represent());
           }
}
