/*
 *  Georgios Bizimis
 *  for 9 / 15 / 2022
 *  HW3. Validating Input. Return on Investment.
 */

package HW3;

import java.util.Locale;
import java.util.Scanner;

public class Investment
{
    private static double Investment(double c, double r, int t, int n)
    {
        return c * Math.pow(1 + r/n, t*n);
    }

    public static void main(String[] args)
    {

        //NEEDED TO FIX AN ERROR I HAD WITH THE DECIMAL SEPARATOR BEING ',' (EUROPEAN NOTATION) INSTEAD OF '.'
        Locale.setDefault(Locale.US);

        System.out.println("----------------------\n\u001B[1mHW3. Validating Input." +
                "\nReturn on Investment\n\u001B[0m----------------------\n");

        final double c, r; final int t, n;
        Scanner kbd = new Scanner(System.in);



        //-----DEPOSIT/INITIAL INVESTMENT--------------------------------------
        System.out.print("Please enter deposit in USD: ");
        if (kbd.hasNextDouble()){
            c = kbd.nextDouble();
        }
        else {
            System.out.printf("Error: please enter a decimal number. You entered \"%s\".", kbd.next());
            return; //exit main
        }
        if (c < 0)
        {
            System.out.printf("Error: please enter a positive number, you entered %.2f$.\n", c);
            return;
        }
        //--------------------------------------------------------------------



        //-----INTEREST RATE--------------------------------------------------
        System.out.print("Please enter an interest rate: ");
        if (kbd.hasNextDouble()){
            r = kbd.nextDouble();
        }
        else {
            System.out.printf("Error: please enter a decimal number. You entered \"%s\".", kbd.next());
            return; //exit main
        }
        if (r < 0 || r > 1)
        {
            System.out.printf("Error: interest rate should be expressed as a decimal between 0 and 1.\n" +
                    "For example 8%% should be entered as '.8'. You entered %.2f.", r);
            return;
        }
        //--------------------------------------------------------------------



        //-----NUMBER OF YEARS------------------------------------------------
        System.out.print("Please enter number of years as integer: ");
        if (kbd.hasNextInt()){
            t = kbd.nextInt();
        }
        else {
            System.out.printf("Error: please enter an integer. You entered \"%s\".", kbd.next());
            return; //exit main
        }
        if (t < 0)
        {
            System.out.printf("Error: please enter a positive number, you entered %d.\n", t);
            return;
        }
        //--------------------------------------------------------------------



        //-----TIMES TO COMPOUND----------------------------------------------
        System.out.print("Give me the number of times to compound: ");
        if (kbd.hasNextInt()){
            n = kbd.nextInt();
        }
        else {
            System.out.printf("Error: please enter an integer number. You entered \"%s\".", kbd.next());
            return; //exit main
        }
        if (n < 0)
        {
            System.out.printf("Error: please enter a positive number, you entered %d.\n", n);
            return;
        }
        //--------------------------------------------------------------------



        System.out.printf("Your investment is worth %.2f$.\n", Investment(c, r ,t , n));
    }

}