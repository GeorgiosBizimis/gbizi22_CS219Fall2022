package HW1;

public final class Time {

    //Called by HelloWorld
    public static void Clock()
    {
        final int total_seconds = 86400; //Total amount of seconds in a day

        //In a real-world application this would be the user's input
        int hour = 15;
        int minute = 6;
        int second = 37;

        final float hour_in_seconds = calculate_in_seconds(hour, minute, second);
        System.out.println(hour_in_seconds + " seconds have passed since midnight.");

        final float seconds_until_midnight =  total_seconds - hour_in_seconds;
        System.out.println("Also, " + seconds_until_midnight + " remain until the day ends");

        final float percentage_of_time_passed = (hour_in_seconds/total_seconds) * 100;
        System.out.println(percentage_of_time_passed + "% of the day has passed.");

        // The exercise requires to change the value of the initial variables to reflect the new time

        // ---THIS IS THE WAY TO DO IT IF WE JUST CHANGE THE INITIAL VARIABLES AND "COMPUTE THE ELAPSED TIME"---
        hour = 15; //same
        minute = 18;
        second = 57;

        final float new_hour_in_seconds = calculate_in_seconds(hour, minute, second);
        final int seconds_that_have_passed = (int)(new_hour_in_seconds - hour_in_seconds);

        final int new_hour = seconds_that_have_passed/3600;
        final int new_minute = (seconds_that_have_passed%3600)/60;
        final int new_second = seconds_that_have_passed%60;

        // ---OUTPUT SYSTEM---
        if (new_hour > 0) System.out.print(new_hour + " hours, ");
        if (new_minute > 0) System.out.print(new_minute + " minutes and ");
        if (new_minute > 0 || new_second > 0) System.out.println(new_second + " seconds have passed since starting this excercise.");
        else System.out.println("No time has passed since starting the exercise.");

        /* ---THIS IS THE WAY TO DO IT BY KEEPING THE OLD VALUES IN NEW VARIABLES---
        final int old_hour = hour;
        final int old_minute = minute;
        final int old_second = second;

        hour = 15; //same
        minute = 14;
        second = 57;

        final int new_hour = hour - old_hour;
        final int new_minute = minute - old_minute;
        final int new_second = second - old_second;

        System.out.println(new_hour + " hour " + new_minute + " minutes and " + new_second + " seconds have passed since starting this excercise.");
        */

        //Still it would make even more sense to introduce new variables for the new time.
    }

    private static float calculate_in_seconds(int hour, int minute, int second)
    {
        return (hour * 3600) + (minute * 60) + second;
    }

}
