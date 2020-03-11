package util;

import ui.Console;

public class NumberCheck {
    public static int getNumber(String s){
        Console console = new Console();
        int number;
        try{
            number = Integer.parseInt(s);
            return number;
        }
        catch (NumberFormatException ex){
            console.print("Please enter a number");
            return getNumber(console.readLine());
        }
    }
}
