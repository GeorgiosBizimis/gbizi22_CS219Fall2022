public class Weather
{

    private static double windchill(double temperature, double wind_velocity)
    {
        return 35.74 + (0.6215 * temperature) + (((0.4275 * temperature) - 35.75) * Math.pow(wind_velocity, 0.16));
    }

    public static void main(String[] args)
    {
        System.out.println(windchill(32, 10));
    }

}
