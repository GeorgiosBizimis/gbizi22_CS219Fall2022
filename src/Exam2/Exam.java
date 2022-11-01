package Exam2;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Exam
{

    private static final String SOLUTIONS_URL = "http://10.60.15.25/~ehar/cs219/wordle-nyt-solutions.txt";

    private static Scanner URLScanner(final String url_string)
    {
        final URL url;

        try {
            url  = new URL(url_string);
            return new Scanner(url.openConnection().getInputStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static String reverse(String s)
    {
        if(s.length() == 0)
            return "";
        else
            return reverse(s.substring(1)) + s.charAt(0);
    }

    private static String[] reverse(final String[] arr)
    {
        String temp;
        for(int i = 0; i < arr.length/2; i++)
        {
            final int mirror = arr.length - 1 - i;
            temp = arr[i];
            arr[i] = arr[mirror];
            arr[mirror] = temp;
        }

        return arr;
    }

    private static String removeSpaces(String s)
    {
        if(s.length() == 0)
            return "";
        else if(s.charAt(0) == ' ')
            return removeSpaces(s.substring(1));
        else
            return s.charAt(0) + removeSpaces(s.substring(1));
    }

    private static boolean isPalindrome(final String s)
    {
        return removeSpaces(s).equals(reverse(removeSpaces(s)));
    }

    private static String[] loadWords(final Scanner scanner, final int length)
    {
        final String[] words = new String[length];
        int i = 0;
        while(scanner.hasNextLine())
        {
            final String nextLine = scanner.nextLine();
            if(isPalindrome(nextLine))
                words[i++] = nextLine;
        }

        return words;
    }

    public static void main(String[] args)
    {
        final String[] palindromes = loadWords(URLScanner(SOLUTIONS_URL), 9);
        System.out.println(Arrays.toString(reverse(palindromes)));
    }

}
