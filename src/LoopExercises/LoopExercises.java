package LoopExercises;

public class LoopExercises
{

    /*
     * Return the sum of the digits mod 10 of an integer. This is one example of
     * a checksum of the integer n.  For example, the checksum of 4198 is
     *
     *     4198 = (4 + 1 + 9 + 8) % 10 = 2
     *
     * Checksums are used to detect errors in network communications.
     *
     * checksum(4198) == 2
     */
    public static int checksum(int n)
    {
        int check = 0;
        while(n > 0)
        {
            check = check + (n % 10);
            n = n / 10;
        }

        return check % 10;  // just to shut up error message
    }

    /*
     * Append the checksum digit as the least significant digit
     * to n and return it.
     */

    public static int appendChecksum(int n)
    {
        return n * 10 + checksum(n);
    }

    /*
     * count7s  returns the number of times the digit 7 appears in
     * the parameter n.
     *
     * count7s(1727337) = 3
     * count7s(1234) = 0
     * count7s(777777) = 6
     *
     * Question: Does the function work if n is negative?
     */
    public static int count7s(int n)
    {
        int count = 0;

        while(n != 0)
        {
            if (n % 10 == 7) count++;
            n = n /10;
        }

        return count;  // just to shut up error message
    }

    /*
     *  If we list all the natural numbers below 10 that are multiples
     *  of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     *  Find the sum of all the multiples of 3 or 5 below 1000.
     *
     *  https://projecteuler.net/problem=1
     *
     *  n should be non-negative
     *  sum3or5(10) = 23
     *  sum3or5(1000) = 233168
     */
    public static int sum3or5(int n)
    {
        int count = 0;
        for(int i = 0;i < n; i++)
        {
            if(i % 3 == 0 || i % 5 == 0)
            {
                count += i;
            }
        }
        return count;  // shut up error message
    }

    /*
     * Return the first factor of n greater than 1
     * and less than n. If no factors return -1.
     * Notice that this function uses longs and not ints.
     *
     *  factor(59953793) == 7727
     *  factor(1531482031) == -1
     *  factor(7304692485435694493L) == -1;
     *
     * Question: Notice the letter L on the end of the largest integer above?
     *           Any guess of what it means or why it is there?  What happens if
you
     *           remove it?
     */
    public static long factor(long n)
    {
        for(int i = 2; i < n; i++)
        {
            if(n % i == 0) return -1;
        }
        return n;
    }

    /*
     * Write a function stars(n) that wil print n asterisks
     * on the console window.
     *
     * stars(5) will print *****
     *
     * Question: Why is this a void function?
     */
    public static void stars(int n)
    {
        //It is a void function because it prints the stars directly from the body of the method and does not return the stars
        //in the form of a string.
        for(int i = 0; i <= n; i++)
        {
            System.out.print('*');
        }
    }

    /*
     * Write a function triangle that takes an integer n and will print
     * a right triangle of n rows where the first row has 1 asterisk
     * and the nth row has n asterisks, For example,
     *
     * triangle(5) will print
     *
     *         *
     *         **
     *         ***
     *         ****
     *         *****
     *
     *  Hint: use the function stars you defined above.
     */
    public static void triangle(int n)
    {
        for(int i = 0; i <= n; i++)
        {
            System.out.println();
            for (int x = 0; x <= i; x++)
            {
                System.out.print('*');
            }
        }
    }

    /*
     *  Fizz Buzz
     *
     *  Write a function fizzbuzz that takes an integer n and
     *  prints out the integers from 1 to n. If the number is
     *  divisible by 3 print "fizz" instead of the number. If
     *  the number is divisible by 5 then print "buzz" instead
     *  of the number. And if it is divisible by 3 and 5 it prints "fizz buzz".
     *
     *  For example, calling fizzbuzz(16) would print
     *  1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz 16
     *
     *  Instead of commas you can print each entry on its own line.
     *
     *  https://en.wikipedia.org/wiki/Fizz_buzz
     *
     */
    public static void fizzbuzz(int n)
    {
        System.out.println();
        for(int i = 1; i <= n; i++)
        {
            if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.print("fizz buzz");
            }
            else if(i % 3 == 0)
            {
                System.out.print("fizz");
            }
            else if(i % 5 == 0)
            {
                System.out.print("buzz");
            }
            else
            {
                System.out.print(i);
            }

            if(i < n) System.out.print(", ");
        }
    }

    /*
     * A palindrome number is an integer n that, when you reverse the digits,
     * gives you n back. For example 121, 11, 2, 1221, 12321, 123321 are
     * all palindrome numbers.  The integer 1234 is not a palindrome integer.
     *
     * Write a boolean function isPalindrome that returns true of the integer
     * n passed to it is a palindrome integer, otherwise it returns false.
     *
     */
    public static boolean isPalindrome(int n)
    {
        final int original = n;
        System.out.println();
        int reversed = 0, remainder;
        while (n != 0) {
            remainder = n % 10;
            reversed = reversed * 10 + remainder;
            n /= 10;
        }

        return original == reversed;
    }

    /*
     * This function is similar to the triangle function; but a little trickier.
     *
     * Write a function named staircase that takes an integer n, and produces the
triangle
     * pattern below. For example calling staircase(5) would print
     *
     *        *
     *       **
     *      ***
     *     ****
     *    *****
     *
     * In general, there are n rows of asterisks where the last row has n
asterisks.
     */
    public static void staircase(int n)
    {
        for(int i = 0; i <= n; i++)
        {
            System.out.println();
            for(int x = 0; x <= n - i; x++)
            {
                System.out.print(' ');
            }
            for(int x = 0; x <= i; x++)
            {
                System.out.print('*');
            }
        }
    }

    /*
     *   perfect number
     *
     *   A perfect number is a number that is equal to the sum of its divisors that
     *   are less than the number. For example, 6 is a perfect number
     *   because 6 = 1 + 2 + 3 and 1,2,3 are the divisors.
     *
     *   28 is also a perfect number because 28 = 1 + 2 + 4 + 7 + 14 and 1,2,4,7,14
are the only
     *   divisors of 28.
     *
     *   Write a function named perfect that takes an integer n and returns true if
n
     *   is a perfect number, and false if it is not.
     *
     *   perfect(28) == true
     *   perfect(496) == true
     *   perfect(99) == false
     */
    public static boolean perfect(int n)
    {
        System.out.println();
        int sum = 0;
        for(int i = 1; i < n; i++)
        {
            if(n % i == 0) sum += i;
        }
        return sum == n;   // shut up error message
    }

    /*
     *   Find perfect numbers
     *
     *   Write a function findPerfect that searches for more perfect numbers.
     *   Check numbers all the way up to 2147483647
     *
     *   Question: What is special about the number 2147483647?
     */
    private static void findPerfect()
    {
        for(int i = 1; true; i++)
        {
            if(Math.sqrt(i) % 1 == 0) System.out.println(i);
        }
    }

    /*
     * Thoroughly test all of your functions above.
     */

    public static void main(String[] args)
    {
        System.out.println(appendChecksum(91217) == 912170);
        System.out.println(appendChecksum(91217) != 912179); //negative test
        System.out.println(count7s(34879787) == 3);
        System.out.println(sum3or5(1000));
        stars(8);
        triangle(10);
        fizzbuzz(20);
        System.out.println(isPalindrome(1234554321));
        staircase(20);
        System.out.println(perfect(6));
        System.out.println(!perfect(7));
        findPerfect();
    }

}
