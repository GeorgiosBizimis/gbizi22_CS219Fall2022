package Wordle;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class Game
{

    private final static String SOLUTIONS_URL = "http://10.60.15.25/~ehar/cs219/wordle-nyt-solutions.txt";
    private final static Random rng;

    static {
        rng = new Random();
    }

    private static Scanner URLScanner(final String url_string)
    {
        final URL url; // null is the nothing value

        try {
            url  = new URL(url_string);
            return new Scanner(url.openConnection().getInputStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static String[] loadWords(final Scanner scanner, final int length)
    {
        final String[] words = new String[length];
        int i = 0;
        while(scanner.hasNextLine())
        {
            words[i++] = scanner.nextLine();
        }

        return words;
    }

    private static int indexOf(final String target, final String[] words)
    {
        for(int i = 0; i < words.length; i++)
            if(words[i].equals(target))
                return i;

        return -1;
    }

    private static int binarySearch(final String[] array, final String target, final int low, final int high)
    {
        if(low > high)
            return -1;

        final int mid = (low + high) / 2;
        if(array[mid].equals(target))
            return mid;
        else if(array[mid].compareTo(target) < 0)
            return binarySearch(array, target , mid + 1, high);
        else
            return binarySearch(array, target, low, mid - 1);
    }

    public static void main(String[] args)
    {
        rng.setSeed(23);
        final String[] words = loadWords(URLScanner(SOLUTIONS_URL), 2309);
        final String word = words[rng.nextInt(0, words.length)];
        System.out.println(word);
        System.out.println(indexOf(word, words));
        System.out.println(binarySearch(words, word, 0, words.length - 1));
        System.out.println(Math.floorDiv(-9, 2));
        System.out.println(-9/2);
        System.out.println(Math.floorMod(-9, 2));
        System.out.println(-9%2);
        System.out.println("sdfssdf");
    }

}
