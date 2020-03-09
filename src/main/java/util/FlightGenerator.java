package util;

import entity.Airport;
import entity.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightGenerator {
    Random rand = new Random();

    public void generate(){
        List<Flight> flightList = new ArrayList<>();
        Airport airport = Airport.values()[randomGenerator(0, Airport.values().length)];
        int price = randomGenerator(150,1500);
        int seats = randomGenerator(1,200);
        //in progress
    }

    private int randomGenerator(int start,int bound){
        return rand.nextInt(start-bound)+bound+1;
    }




}
