/*
 *  Georgios Bizimis
 *  for 9 / 15 / 2022
 *  HW3. Validating Input. Return on Investment.
 */

package HW4;

import java.util.Locale;
import java.util.Scanner;

public class Investment
{
    final static Scanner kbd;

    static {
        Locale.setDefault(Locale.US);
        kbd = new Scanner(System.in);
    }

    private static double getInvestmentValue(double c, double r, int t, int n)
    {
        return c * Math.pow(1 + r/n, t*n);
    }

    private static double getInitialDeposit()
    {
        double n;
        System.out.print("Please enter deposit in USD: ");
        while (true)
        {
            if (kbd.hasNextDouble())
            {
                n = kbd.nextDouble();
                if (n < 0)
                {
                    System.out.printf("Error: Please enter a positive number, you entered %.2f$. Please try again: ", n);
                    kbd.nextLine(); //to consume the "\n"
                }
                else
                {
                    kbd.nextLine(); //to consume the "\n"
                    return n;
                }
            }
            else
            {
                System.out.printf("Error: Please enter a decimal number. You entered \"%s\". Please try again: ", kbd.nextLine());
            }
        }
    }

    private static double getInterestRate()
    {
        double n;
        System.out.print("\nPlease enter an interest rate: ");
        while(true)
        {
            if (kbd.hasNextDouble())
            {
                n = kbd.nextDouble();
                if (n < 0 || n > 1)
                {
                    System.out.printf("Error: Interest rate should be expressed as a decimal between 0 and 1.\n" +
                            "For example 8%% should be entered as '.8'. You entered %.2f. Please try again: ", n);
                    kbd.nextLine(); //to consume the "\n"
                }
                else
                {
                    kbd.nextLine(); //to consume the "\n"
                    return n;
                }
            }
            else
            {
                System.out.printf("Error: Please enter a decimal number. You entered \"%s\". Please try again: ", kbd.nextLine());
            }
        }
    }

    private static int getNumberOfYears()
    {
        int n;
        System.out.print("\nPlease enter the number of years as an integer: ");
        while(true)
        {
            if (kbd.hasNextInt()){
                n = kbd.nextInt();
                if (n < 0)
                {
                    System.out.printf("Error: Please enter a positive number, you entered %d. Please try again: ", n);
                    kbd.nextLine(); //to consume the "\n"
                }
                else
                {
                    kbd.nextLine(); //to consume the "\n"
                    return n;
                }
            }
            else
            {
                System.out.printf("Error: Please enter an integer. You entered \"%s\". Please try again: ", kbd.nextLine());
            }
        }
    }

    private static int getTimesToCompound()
    {
        int n;
        System.out.print("\nPlease enter the number of times to compound: ");
        while(true)
        {
            if (kbd.hasNextInt()){
                n = kbd.nextInt();
                if (n < 0)
                {
                    System.out.printf("Error: Please enter a positive number, you entered %d.Please try again: \n", n);
                    kbd.nextLine(); //to consume the "\n"
                }
                else
                {
                    kbd.nextLine(); //to consume the "\n"
                    return n;
                }
            }
            else
            {
                System.out.printf("Error: Please enter an integer number. You entered \"%s\". Please try again: ", kbd.nextLine());
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("""
                --------------------------------
                \u001B[1mHW4 - Better Validating Inputs
                     Return on Investment
                \u001B[0m--------------------------------
                """);

        System.out.printf("\u001B[1m\n-> Your investment is worth %.2f$. <-\n",
                getInvestmentValue(getInitialDeposit(), getInterestRate(), getNumberOfYears(), getTimesToCompound()));
    }

}