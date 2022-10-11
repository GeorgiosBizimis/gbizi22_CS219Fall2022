/*
 *  Georgios Bizimis
 *  for 10 / 12 / 2022
 *  HW6 - SwallowStats
 */

package HW6;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public final class SwallowStats
{

    private static Scanner URLScanner(final String url_string)
    {
        final URL url; // null is the nothing value

        try {
            url  = new URL(url_string);
            return new Scanner(url.openConnection().getInputStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void swallow_stats()
    {
        // connect to the webpage of speeds
        final Scanner s = URLScanner("http://10.60.15.25/~ehar/cs219/swallow-speeds.txt");

        double sum = 0;
        int count = 0;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        while(true)
        {
            try {
                final String line = s.nextLine();
                if(!line.contains("#") && !line.isBlank())
                {
                    final double number = Double.parseDouble(line);
                    System.out.println(number);
                    sum += number;
                    count++;
                    if(number < min) min = number;
                    if(number > max) max = number;
                }
            }
            catch(Exception e)
            {
                break;
            }
        }
        System.out.println();
        System.out.printf("The average swallow speed is %.2f\n", sum/count);
        System.out.printf("The minimum swallow speed is %.1f\n", min);
        System.out.printf("The maximum swallow speed is %.1f\n", max);
    }

    public static void main(String[] args)
    {
        swallow_stats();
    }

}
