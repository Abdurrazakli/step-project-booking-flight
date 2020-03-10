package dao;

import entity.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDAO implements DAO<Booking> {
    private final String BOOKING_DB_PATH = "data/bookings.bin";
    private Database<Booking> db = new Database<>();

    @Override
    public Optional get(int id) {
       return Optional.of(getAll()
               .stream()
               .filter(b->b.ID == id)
               .collect(Collectors.toList())
               .get(0));
    }

    @Override
    public List<Booking> getAll() {
        return db.read(BOOKING_DB_PATH);
    }

    @Override
    public boolean create(Booking booking) {
        List<Booking> bookings = new ArrayList<>(getAll());
        bookings.add(booking);
        return db.write(BOOKING_DB_PATH,bookings);
    }

    @Override
    public boolean delete(int id) {
        List<Booking> all =  getAll();
        List<Booking> deleted = all.stream().filter(b -> b.ID != id).collect(Collectors.toList());
        if (all.size() == deleted.size()) return false;
        return db.write(BOOKING_DB_PATH,deleted);
    }
}
