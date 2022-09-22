package Utility;

import java.util.Scanner;

public class Weather
{

    private static double windchill(double temperature, double wind_velocity)
    {
        return 35.74 + (0.6215 * temperature) + (((0.4275 * temperature) - 35.75) * Math.pow(wind_velocity, 0.16));
    }

    private static double getVelocity(Scanner s)
    {
        double velocity;
        while(true)
        {

            System.out.print("Enter a wind velocity in MPH: ");
            if(s.hasNextDouble())
            {
                velocity = s.nextDouble();
                if(velocity > 0) break;
                else System.out.printf("PLease enter a positive number %.2f", velocity);
            }
            else {
                System.out.printf("Error: please enter a decimal number. You entered \"%s\".", s.next());
            }
        }
        return velocity;
    }
    
    private static double getTemperature(Scanner s)
    {
        System.out.print("Enter temperature in degrees F: ");
        double temperature = 0;
        while(true)
        {
            if (s.hasNextDouble()){
                temperature = s.nextDouble();
                break;
            }
            else {
                System.out.printf("Error: please enter a decimal number. You entered \"%s\".", s.next());
            }
        }

        return temperature;
    }

    public static void main(String[] args)
    {
        //Used for getting inout from the keyboard
        Scanner kbd = new Scanner(System.in);

        double velocity = getVelocity(kbd);
        double temperature = getTemperature(kbd);

        System.out.printf("Windchill for %.1f degrees at %.1f MPH is %.2f\n", temperature, velocity, windchill(temperature, velocity));
        System.out.println("They said \"Don't do it\"");
    }

}
