package util;

import java.util.Optional;

public class Parser {

    public Optional<Integer> strToInt(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
