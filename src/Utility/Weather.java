package Utility;

import java.util.Scanner;

public class Weather
{

    private static double windchill(double temperature, double wind_velocity)
    {
        return 35.74 + (0.6215 * temperature) + (((0.4275 * temperature) - 35.75) * Math.pow(wind_velocity, 0.16));
    }

    public static void main(String[] args)
    {

        //Used for getting inout from the keyboard
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter temperature in degrees F: ");
        double temperature;
        if (kbd.hasNextDouble()){
            temperature = kbd.nextDouble();
        }
        else {
             System.out.printf("Error: please enter a decimal number. You entered \"%s\".", kbd.next());
             return; //exit main
        }

        System.out.print("Enter a wind velocity in MPH: ");
        double velocity;
        if(kbd.hasNextDouble())
        {
            velocity = kbd.nextDouble();
        }
        else {
            System.out.printf("Error: please enter a decimal number. You entered \"%s\".", kbd.next());
            return;
        }

        System.out.printf("Windchill for %.1f degrees at %.1f MPH is %.2f\n", temperature, velocity, windchill(temperature, velocity));
        System.out.println("They said \"Don't do it\"");
    }

}
