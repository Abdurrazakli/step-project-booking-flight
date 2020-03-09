package util;

import entity.Airline;
import entity.Airport;
import entity.Flight;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightGenerator {
    public static String FLIGHT_DB_PATH="./data/flights.bin";
    private static int FLIGHT_COUNT = randomGenerator(10, 20);

    public static List<Flight>  generate(){
        return IntStream.range(1, FLIGHT_COUNT).mapToObj(id ->
                new Flight(id,
                        String.format("%s%d", Airline.values()[randomGenerator(0, (Airline.values().length - 1))].getAirlineCode(), randomGenerator(100, 999)),
                        Airport.values()[randomGenerator(0, Airport.values().length - 1)],
                        Airport.values()[randomGenerator(0, Airport.values().length - 1)],
                        randomGenerator(150, 1500),
                        randomGenerator(1, 200),
                        ZonedDateTime.now(ZoneId.of("GMT+04:00")).plusHours(randomGenerator(1, 23)))).collect(Collectors.toList());
    }

    private static int randomGenerator(int start,int bound){
        Random rand = new Random();
        return rand.nextInt(bound-start)+start+1;
    }
}
