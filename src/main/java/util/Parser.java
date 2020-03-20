package util;

import ui.Console;

import java.util.Optional;

public class Parser {
    private static Optional<Integer> strToInt(String s){
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static int getUserChoice(Console c) {
        Optional<Integer> oi = Optional.empty();
        while (oi.isEmpty()) {
            String s = c.readLine();
            oi = Parser.strToInt(s);
            if (oi.isEmpty()) c.print("Enter a valid number");
        }
        return oi.get();
    }
}
