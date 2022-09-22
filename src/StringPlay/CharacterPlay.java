package StringPlay;

public class CharacterPlay
{
    private static int countVowels(String s)
    {
        int count = 0;
        for(int i = 0; i < s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i'
                    || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(countVowels("applesauce") == 5);
        System.out.println(countVowels("Hippopotomonstrosequippedaliaphobia"));
        char ch = 'a';
        System.out.println(ch);
        System.out.println('θ');
    }
}
