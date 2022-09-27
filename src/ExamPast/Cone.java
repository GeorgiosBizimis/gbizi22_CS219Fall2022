package ExamPast;

import java.util.Locale;
import java.util.Scanner;

public class Cone
{

    static Scanner kbd;

    static{
        kbd = new Scanner(System.in);
    }

    private static double volume(final double radius, final double height)
    {
        return 1/3.0 * Math.PI * Math.pow(radius, 2) * height;
    }

    public static void main(String[] args)
    {
        double radius, height;

        System.out.print("Please enter the cone's radius: ");
        while(true)
        {
            if(kbd.hasNextDouble())
            {
                radius = kbd.nextDouble();
                if(radius <= 0)
                {
                    System.out.printf("Error: Please enter a positive number. You entered %.1f. Please try again: ", radius);
                }
                else
                {
                    kbd.nextLine(); //consumes the n
                    break;
                }
            }
            else
            {
                final String s = kbd.nextLine();
                System.out.printf("Error: Please enter a number. You entered \"%s\". Please try again: ", s);
            }
        }

        System.out.print("Please enter the cone's height: ");
        while(true)
        {
            if(kbd.hasNextDouble())
            {
                height = kbd.nextDouble();
                if(height <= 0)
                {
                    System.out.printf("Error: Please enter a positive number. You entered %.1f. Please try again: ", height);
                }
                else
                {
                    //kbd.nextLine(); //consumes the n
                    break;
                }
            }
            else
            {
                final String s = kbd.nextLine();
                System.out.printf("Error: Please enter a number. You entered \"%s\". Please try again: ", s);
            }
        }

        System.out.printf("The volume of the sphere with radius %f and height %f is %f.", radius, height, volume(radius, height));
    }

}
