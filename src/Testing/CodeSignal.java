package Testing;

import java.util.Arrays;
import java.util.Scanner;

public class CodeSignal {

    private static boolean[] solution(int[] numbers, int left, int right) {
        final boolean[] result = new boolean[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            result[i] = false;
            for(int x = left; x < right; x++)
                if (numbers[i] == (i + 1) * x) {
                    result[i] = true;
                    break;
                }
        }

        return result;
    }

    private static String guarantee(final int length, final String line)
    {
        if(line.substring(0, length/2).equals(line.substring(length/2 + 1)))
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 5, 7, 6, 7, 8, 9}, 1, 3)));
        System.out.println(guarantee(6, "abcabc"));
    }

}
