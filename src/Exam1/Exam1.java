package Exam1;

import java.util.Scanner;

public class Exam1
{

    final static Scanner kbd;

    static{
        kbd = new Scanner(System.in);
    }

    private static int compute(int n)
    {
        int count = 0;
        while(n > 0)
        {
            final int x = n % 10;
            if(x > 2 && x < 7) count++;
            n = n / 10;
        }
        return count;
    }

    private static int getUserInput()
    {
        int n;
        System.out.print("Please enter a number: ");
        while(true)
        {
            if(kbd.hasNextInt())
            {
                n = kbd.nextInt();
                if(n <= 0)
                {
                    kbd.nextLine(); //consumes the n
                    System.out.printf("Error: Please enter a positive number. You entered %d. Please try again: ", n);
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
                System.out.printf("Error: Please enter an integer number. You entered \"%s\". Please try again: ", s);
            }
        }
        return n;
    }

    public static void main(String[] args)
    {
        final int input = getUserInput();
        System.out.printf("\u001B[1m\nThe number of digits in %d which are between 2 and 7 is %d.", input, compute(input));
    }

}
