package dao;

import entity.Flight;
import entity.User;
import util.FlightGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {

    Database<Flight> db = new Database<>();

    @Override
    public Optional<Flight> get(int id) {
        return getAll().flatMap(flights ->
                flights.stream().filter(flight ->
                        flight.ID == id).findAny());
    }

    @Override
    public Optional<List<Flight>> getAll() {
        return db.read(FlightGenerator.FLIGHT_DB_PATH);
    }

    @Override
    public Boolean create(Flight flight) {
        throw new IllegalArgumentException("Generated Randomly!");
    }

    @Override
    public Boolean delete(int id) {
        return db.write(FlightGenerator.FLIGHT_DB_PATH, getAll().map(flights ->
                flights.stream().filter(flight ->
                        flight.ID != id).collect(Collectors.toList())).get());
    }
}
