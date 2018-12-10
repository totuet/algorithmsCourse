package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class teest {
    public static void main(String args[]) {
        LocalDate date = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        date.plusDays(2);
        //date.plusHours(3);
        System.out.println(date.getYear() + " " + date.getMonth() + " "
                + date.getDayOfMonth());




    }
}