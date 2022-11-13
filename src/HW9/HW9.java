package HW9;

import java.math.BigInteger;

public class HW9 {

    /*
        Compute x raised to the y power using a simple iterative process
        (i.e., a loop). Do not use BigInteger's built in pow function.
        Use the function pow we wrote in Chap9ImmutableObjects.BigIntegerPlay
        as a guide.
     */
    public static BigInteger bigPow(final BigInteger x, final int y)
    {
        BigInteger prod = BigInteger.ONE;
        for(int i = 0; i < y; i++)
            prod = prod.multiply(x);

        return prod;
    }

    /*
        Compute x raised to the y power using the recursive definition
        from the programming assignment in Canvas. Do not use BigInteger's
        built in pow function.
     */
    public static BigInteger bigPowFast(final BigInteger x, final int y)
    {
        if(y == 0)
            return BigInteger.ONE;
        else if(y % 2 == 0)
            return bigPowFast(x, y/2).multiply(bigPowFast(x, y/2));
        else
            return x.multiply(bigPowFast(x, y - 1));
    }

    public static void main(String[] args)
    {
        final BigInteger x = new BigInteger("1029883673");

        // Test bigPow
        BigInteger z = bigPow(x,10);
        System.out.println(z.toString().equals("1342399346995612672464070989837373830965198185983932347990254056431651542191037112352025649"));

        // make sure our result agrees with BigInteger's built in pow function.
        System.out.println(bigPow(z, 100).equals(z.pow(100)));

        // Test bigPowFast
        z = bigPowFast(x,10);
        System.out.println(z.toString().equals("1342399346995612672464070989837373830965198185983932347990254056431651542191037112352025649"));

        // make sure our result agrees with BigInteger's built in pow function.
        System.out.println(bigPowFast(z, 100).equals(z.pow(100)));
    }

}
