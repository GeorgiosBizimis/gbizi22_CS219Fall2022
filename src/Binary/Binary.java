package Binary;

public class Binary
{

    private static void printBinary(int n)
    {
        if(n == 0)
            System.out.print(0);
        else {
            printBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static String toBinary(int n)
    {
        final StringBuilder r = new StringBuilder();
        while(n > 0) {
            r.insert(0, n % 2);
            n = n / 2;
        }
        return r.toString();
    }

    public static int parseInt(String bits)
    {
        int currentPower2 = 1;
        int r = 0;

        for(int i = bits.length() - 1; i >= 0; i--) {
            if(bits.charAt(i) == '1') {
                r += currentPower2;
            }
            currentPower2 *= 2;
        }

        return r;
    }

    public static void main(String[] args)
    {
        printBinary(43); // 101011
        System.out.println("\n" + toBinary(43));
        System.out.println(parseInt("0101011") == 43);
        System.out.println(Integer.toBinaryString(43));
        System.out.println(0b11111111111111111111111111111111);
        System.out.println(0xFFFFFFFF);
    }

}
