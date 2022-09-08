import Utility.Investment;

import java.util.Scanner;

public class InvestmentCalculator
{

    public static void main(String[] args)
    {
        // prompt the user for c, r, t, n
        // call the function with the inputed values
        final double c, r;
        final int t, n;

        Scanner kbd = new Scanner(System.in);
        System.out.print("Please enter deposit:");
        c = kbd.nextDouble();
        System.out.print("Please enter interest rate:");
        r = kbd.nextDouble();
        System.out.print("Please enter number of years as integer:");
        t = kbd.nextInt();
        System.out.print("Give me the number of times to compound:");
        n = kbd.nextInt();

        System.out.printf("Your investment is worth %.2f", Investment.Investment(c, r ,t , n));
    }

}
