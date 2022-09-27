package Chap6Execises;

public class Exercises64
{

    private static boolean isAbecederian(String s)
    {
        for(int i = 0; i < s.length() - 1; i++)
        {
            if(s.charAt(i) > s.charAt(i + 1))
            {
                return false;
            }
        }

        return true;
    }

    private static String toLower(String s)
    {
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z')
                r.append((char) ('a' + (ch - 'A')));
            else
                r.append(ch);
        }
        return r.toString();
    }

    private static boolean isAlphabetical(String s)
    {
        s = toLower(s);
        int i = 0;
        while(i < s.length() -1)
        {
            if(s.charAt(i) > s.charAt(i + 1))
            {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(toLower("APPLE&^%#*&^%$#@"));
        System.out.println(isAlphabetical("mossy"));
    }

}
