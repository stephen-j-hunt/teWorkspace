package com.techelevator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LD {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate eomJan = LocalDate.of(2023, 01, 31);
        System.out.println(eomJan);

        // comparing
        System.out.println(today.equals(eomJan));
        System.out.println(today.isBefore(eomJan));
        System.out.println(today.isAfter(eomJan));

        System.out.println(today.plusDays(1));
        System.out.println(eomJan.plusDays(30));
        System.out.println(eomJan.plusMonths(1));
        System.out.println(eomJan.plusMonths(1).plusMonths(1));
        System.out.println(today.plusDays(-1));

        System.out.println(today.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy MM dd")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy MMM dd")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyyMMdd")));

    }
}
