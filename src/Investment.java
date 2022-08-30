public class Investment
{
    public static double Investment(double c, double r, int t, int n)
    {
        return c * Math.pow(1 + r/n, t*n);
    }

    public static void main(String[] args)
    {
        System.out.println(Investment(1000,.03,10, 365));
    }

}
