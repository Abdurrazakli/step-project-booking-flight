package dao;

import entity.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {
    private final String FLIGHT_DB_PATH = "need to feel";
    private Database<Flight> db = new Database<>();
    @Override
    public Optional<Flight> get(int id) {
        return  getAll().flatMap(flights ->
                flights.stream()
                .filter(s->s.ID == id).findFirst());
    }

    @Override
    public Optional<List<Flight>> getAll() {
        return db.read(FLIGHT_DB_PATH);
    }

    @Override
    public boolean create(Flight flight) {
        if(!isFlightExist(flight)){
            List<Flight> flights = new ArrayList<>(getAll().orElseGet(()-> Collections.EMPTY_LIST));
            flights.add(flight);
            db.write(FLIGHT_DB_PATH,flights);
            return true;
        }
        throw new RuntimeException("There is not such a flight");
    }

    @Override
    public boolean delete(int id) {
        return db.write(FLIGHT_DB_PATH,getAll().map(flights ->
                flights
                        .stream()
                        .filter(flight ->
                                flight.ID != id)
                        .collect(Collectors.toList()))
                .get());
    }

    private boolean isFlightExist(Flight flight){
       return getAll()
                .get()
                .stream()
                .collect(Collectors.toList())
                .contains(flight);
    }
}
