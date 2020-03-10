package dao;

import entity.Booking;

import java.util.List;
import java.util.Optional;

public class BookingDAO implements DAO<Booking> {
    @Override
    public Optional<Booking> get(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Booking>> getAll() {
        return Optional.empty();
    }

    @Override
    public boolean create(Booking booking) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
