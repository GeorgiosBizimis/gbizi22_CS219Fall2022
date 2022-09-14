package LogicExercises;

public class Logic
{

    private static int caughtSpeeding(int speed, boolean isBirthday)
    {
        if(isBirthday)
        {
            if(speed <= 65)
            {
                return 0;
            }
            else if(speed < 86)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            if(speed <= 60)
            {
                return 0;
            }
            else if(speed < 81)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }

    }

    private static boolean cigarParty(int cigars, boolean isWeekend)
    {
        return (isWeekend && cigars >= 40) || (40 <= cigars && cigars <= 600);
    }

    private static boolean ordered(int d1, int d2, int d3)
    {
        return (d1 < d2 && d2 < d3) || (d3 < d2 && d2 < d1);
    }

    public static void main(String[] args)
    {
        System.out.println("Caught Speeding:");
        System.out.println(caughtSpeeding(60, false) == 0);
        System.out.println(caughtSpeeding(65, false) == 1);
        System.out.println(caughtSpeeding(65, true) == 0);
        System.out.println(caughtSpeeding(81, false) == 2);
        System.out.println(caughtSpeeding(81, true) == 1);
        System.out.println("\nCigar Party:");
        System.out.println(cigarParty(30, false));
        System.out.println(cigarParty(50, true));
        System.out.println(cigarParty(70, true));
        System.out.println("\nOrdered:");
        System.out.println(ordered(1, 2 ,3));
        System.out.println(ordered(3, 2 ,1));
        System.out.println(ordered(3, 2 ,5));
    }

}
