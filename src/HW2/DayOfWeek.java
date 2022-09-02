package HW2;

import java.util.Scanner;

public final class DayOfWeek
{
    private static int dayofweek(int month, int day, int year)
    {
        final int y = year - (14 - month)/12;
        final int x = y + (y/4) - (y/100) + (y/400);
        final int m = month + 12 * ((14 - month)/12) - 2;
        return (day + x + (31 * m)/12) % 7;
    }

    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);
        final int year, month, day;

        System.out.print("Enter the current month's number please: ");
        month = kbd.nextInt();
        System.out.print("Enter the current day's number in the current month please: ");
        day = kbd.nextInt();
        System.out.print("Enter the current year please: ");
        year = kbd.nextInt();

        final int day_number = dayofweek(month, day, year);
        System.out.println(day_number);

        // ---or even better---
        System.out.println(day_name(day_number));
    }

    private static String day_name(int day_number)
    {
        final String[] names = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return names[day_number];
    }

}
