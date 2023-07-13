package dev.belavirag.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        extraAssignment();
    }

    private static void ex1() {
        final LocalDate today = LocalDate.now();
        System.out.println(today);
    }

    private static void ex2() {
        final LocalDate today = LocalDate.now();
        System.out.println(today.format(DateTimeFormatter.ofPattern("eeee dd MMM")));
    }

    private static void ex3() {
        final LocalDate previousMonday = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));

        for (int i = 0; i < 7; i++) {
            System.out.println(previousMonday.plusDays(i));
        }
    }

    private static void ex4() {
        final LocalDate parsed = LocalDate.parse("2023-07-13");
        System.out.println(parsed);
    }

    private static void ex5() {
        final LocalDate parsed = LocalDate.parse("1945-05-08");
        System.out.println(parsed.getDayOfWeek());
    }

    private static void ex6() {
        final LocalDate calc = LocalDate.now().plusYears(10).minusMonths(10);
        System.out.println(calc.getMonth());
    }

    private static void ex7() {
        final LocalDate calc = LocalDate.now().plusYears(10).minusMonths(10);
        final LocalDate myBirthday = LocalDate.parse("1999-12-13");
        final Period p = Period.between(myBirthday, calc);

        System.out.printf("years: %d, months: %d, days: %d%n", p.getYears(), p.getMonths(), p.getDays());
    }

    private static void ex8() {
        final Period p = Period.of(4, 7, 29);
        final LocalDate now = LocalDate.now();

        System.out.println(now.plus(p));
    }

    private static void ex9() {
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
    }

    private static void ex10() {
        System.out.println(LocalTime.now().getNano());
    }

    private static void ex11() {
        System.out.println(LocalTime.parse("10:12:32"));
    }

    private static void ex12() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    private static void ex13() {
        final LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.of(2018, 4, 5),
                LocalTime.of(10, 0)
        );
        System.out.println(localDateTime);
    }

    private static void ex14() {
        final LocalDateTime localDateTime = LocalDateTime.of(
                LocalDate.of(2018, 4, 5),
                LocalTime.of(10, 0)
        );

        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }

    private static void ex15() {
        // see ex13
    }

    private static void ex16() {
        final LocalDateTime localDateTime = LocalDateTime.now();

        final LocalDate date = localDateTime.toLocalDate();
        final LocalTime time = localDateTime.toLocalTime();
        System.out.printf("%s, %s%n", date, time);
    }

    private static void extraAssignment() {
        final int year = 2018;
        final Scanner scanner = new Scanner(System.in);

        System.out.printf("Calendar for %d%n%n", year);
        Month currentMonth = Month.JANUARY;
        while (true) {
            final LocalDate actualDate = LocalDate.of(year, currentMonth, 1);

            System.out.printf("\t%s %d%n", currentMonth, year);
            for (int i = 0; i < actualDate.lengthOfMonth(); i++) {
                final LocalDate date = actualDate.plusDays(i);
                System.out.print(date.getDayOfMonth() + ", ");
                if ((i + 1) % 7 == 0) {
                    System.out.println();
                }
            }

            if (currentMonth.plus(1) == Month.JANUARY) {
                // loop back
                currentMonth = Month.JANUARY;
                System.out.printf("%nLooping back to %d", year);
            } else {
                currentMonth = currentMonth.plus(1);
            }

            System.out.printf("%n%nPress enter to go to the next month%n");
            scanner.nextLine();
        }
    }
}