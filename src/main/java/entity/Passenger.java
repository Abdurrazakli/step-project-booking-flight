package entity;

import java.util.Objects;

public class Passenger {
    public final String name;
    public final String surname;
    public final User bookedBy;

    public Passenger(String name, String surname, User bookedBy) {
        this.name = name;
        this.surname = surname;
        this.bookedBy = bookedBy;
    }
    private String represent(){
        return String.format("%s %s %s",name,surname,bookedBy.username);
    }

    @Override
    public String toString() {
        return String.format("Passenger: [%s]",represent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,surname,bookedBy);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return passenger.bookedBy == this.bookedBy;
    }
}
