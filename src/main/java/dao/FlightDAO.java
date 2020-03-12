package dao;

import entity.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {
    private final String FLIGHT_DB_PATH;
    private FileOperations<Flight> db = new FileOperations<>();

    public FlightDAO(String flight_db_path) {
        FLIGHT_DB_PATH = flight_db_path;
    }

    @Override
    public Optional<Flight> get(int id) {
        return  Optional.of(getAll()
                .stream()
                .filter(f->f.ID == id)
                .collect(Collectors.toList())
                .get(0));
    }

    @Override
    public List<Flight> getAll() {
        return db.read(FLIGHT_DB_PATH);
    }

    @Override
    public boolean create(Flight flight) {
        if(!isFlightExist(flight)){
            List<Flight> flights = new ArrayList<>(getAll());
            flights.add(flight);
            return db.write(FLIGHT_DB_PATH,flights);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Flight> all =  getAll();
        List<Flight> deleted = all.stream().filter(f -> f.ID != id).collect(Collectors.toList());
        if (all.size() == deleted.size()) return false;
        return db.write(FLIGHT_DB_PATH,deleted);
    }

    private boolean isFlightExist(Flight flight){
       return getAll().contains(flight);
    }
}
