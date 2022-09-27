import java.util.Scanner;

public class ExamStudy
{

    public static double f2c(double f) {
        return 5/9.0 * (f - 32);
    }

    private static double c2f(double c)
    {
        return 9/5.0 * c + 32;
    }

    public static void main(String[] args) {
        System.out.println(Math.round(6.02235e4));
        System.out.printf("%.3f\n", 3.14159);
        System.out.println('d' - 'a'); // weird
        System.out.println(2 + "bc");
        System.out.println(2 + 3 + "bc");
        System.out.println((2 + 3) + "bc");
        System.out.println("bc" + 2 + 3);
        System.out.println("bc" + (2 + 3));
        System.out.println();
        String s = "hippopotomonstrosesquippedaliophobia";
        System.out.println(s.charAt(0));
        System.out.println(s.indexOf('q'));
        System.out.println(s.indexOf('o'));
        System.out.println(s.substring(s.indexOf('m'),s.indexOf('s')));
        System.out.println(s.charAt(s.length() - 1));

        Scanner kbd = new Scanner(System.in);
        System.out.println("");
    }

}
