package util;

import dao.FileOperations;
import entity.Airline;
import entity.Airport;
import entity.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightGenerator {
    public static String FLIGHT_DB_PATH="./data/flights.bin";
    private static int FLIGHT_COUNT = randomGenerator(80, 130);

    public static List<Flight>  generate(){
        return IntStream.range(1, FLIGHT_COUNT).mapToObj(id ->
                new Flight(id,
                        String.format("%s%d", Airline.values()[randomGenerator(0, (Airline.values().length - 1))].getAirlineCode(), randomGenerator(100, 999)),
                        Airport.values()[randomGenerator(0, Airport.values().length - 1)],
                        Airport.values()[randomGenerator(0, Airport.values().length - 1)],
                        randomGenerator(150, 1500),
                        randomGenerator(1, 200),
                        LocalDate.now().plusDays(randomGenerator(0,10)))).collect(Collectors.toList());
    }

    private static int randomGenerator(int start,int bound){
        Random rand = new Random();
        return rand.nextInt(bound-start)+start+1;
    }

    public static void generation() {
        FileOperations<Flight> flightFileOperations = new FileOperations<>();
        generate().forEach(flight -> flightFileOperations.write(FLIGHT_DB_PATH,generate()));
    }
}
