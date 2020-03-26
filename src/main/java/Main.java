import dao.FileOperations;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();


        LocalDate date  = LocalDate.now();
        LocalDate date1 = LocalDate.now().plusDays(1);
        Period p = Period.between(date,date1);
        System.out.println(p.getMonths());


        bookingManager.run();


    }
}
