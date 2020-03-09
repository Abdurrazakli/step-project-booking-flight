package dao;

import entity.Flight;

import java.util.List;
import java.util.Optional;

public class FlightDAO implements DAO<Flight> {
    @Override
    public Optional<Flight> get(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Flight>> getAll() {
        return Optional.empty();
    }

    @Override
    public Boolean create(Flight flight) {
        throw new IllegalArgumentException("Not impl");
    }

    @Override
    public Boolean delete(int id) {
        throw new IllegalArgumentException("Not impl");
    }
}
