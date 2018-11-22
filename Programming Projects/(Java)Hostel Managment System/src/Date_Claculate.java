
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wael
 */
public class Date_Claculate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //add 1 month to the current date
        LocalDate date2 = today.plus(6, ChronoUnit.MONTHS);
        System.out.println("6 month later: " + date2);

        // Put latest date 1st and old date 2nd in 'between' method to get -ve date difference
        long daysNegative = ChronoUnit.DAYS.between(date2, today);
        System.out.println("Days : "+daysNegative);

        // Put old date 1st and new date 2nd in 'between' method to get +ve date difference
        long datePositive = ChronoUnit.DAYS.between(today, date2);
        System.out.println("Days : "+datePositive);
    }
}
