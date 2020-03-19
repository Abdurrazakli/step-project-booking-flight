package dao;

import entity.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDAO implements DAO<Booking> {
    private final String BOOKING_DB_PATH;
    private FileOperations<Booking> db = new FileOperations<>();

    public BookingDAO(String booking_db_path) {
        this.BOOKING_DB_PATH = booking_db_path;
    }

    @Override
    public Optional get(int id) {
       return Optional.of(getAll()
               .stream()
               .filter(b->b.getID() == id)
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
        List<Booking> deleted = all.stream().filter(b -> b.getID() != id).collect(Collectors.toList());
        if (all.size() == deleted.size()) return false;
        return db.write(BOOKING_DB_PATH,deleted);
    }
}
