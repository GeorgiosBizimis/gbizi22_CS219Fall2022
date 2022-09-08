package Utility;

public class DigitExtractor
{

    private static int last(int n)
    {
        if (n < 0)
        {
            n = -n;
        }
        return n % 10;
    }

    private static int secondToLast(int n)
    {
        n = Math.abs(n);
        return (n % 100) / 10;
    }

    private static int thirdToLast(int n)
    {
        n = Math.abs(n);
        return (n % 1000) / 100;
    }

    private static int anyToLast(int n, int number)
    {
       n = Math.abs(n);
       int tenth = (int) Math.pow(10, number);
       return (n % tenth) / (tenth/10);
    }

    public static void main(String[] args)
    {
        System.out.println(last(2753) == 3);
        System.out.println(last(-749) == 9);
        System.out.println(anyToLast(-230498263,5));
    }

}
