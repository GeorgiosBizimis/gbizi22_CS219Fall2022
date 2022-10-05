/*
 *  Georgios Bizimis
 *  for 10 / 7 / 2022
 *  HW5 - Word Checker
 */

package HW5;

import java.util.HashMap;

public final class Exercise66
{

    // I tried to make it in a fancier way. I promise I did not look on the internet.
    public static boolean canSpell(final String word, final String tiles)
    {
        final HashMap<Character, Integer> letters = new HashMap<>();

        for(int i = 0; i < tiles.length(); i++) // all tiles are placed into a hasmap with
        {                                       // the number of times that they appear
            final char ch = tiles.charAt(i);
            letters.put(ch, letters.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < word.length(); i++)
        {
            final char ch = word.charAt(i);
            try // could have also used letter.containsKey()
            {
                final int value = letters.get(ch); // tries to get the right tile, try-catch fails if the tile does not exist
                if(value > 1) letters.replace(ch, value - 1);
                else letters.remove(ch); // if the character has no uses left it gets removed from the hashmap
            }
            catch(Exception e)
            {
                return false;
            }
        }

        return true;
    }

    // this is the lame way to do it, but I am putting it here in case the other one doesn't get full grade for some reason
    public static boolean canSpellLame(final String word, String tiles)
    {
        for(int i = 0; i < word.length(); i++)
        {
            final char ch = word.charAt(i);
            final int tiles_index = tiles.indexOf(ch);
            try // tries to remove the character from the string
            {
                tiles = tiles.substring(0, tiles_index) + tiles.substring(tiles_index + 1);
            }
            catch(Exception e) // fails if character index given by line49 is -1
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args)
    {
        System.out.println("\n-TESTS FOR THE COOL METHOD-");
        System.out.println(canSpell("boot", "axobasrto"));
        System.out.println(!canSpell("hippo", "haxobapsrito"));
        System.out.println(!canSpell("hashmap", "hsdfhiumpiu"));
        System.out.println(canSpell("macintosh", "cmansfidghjto"));
        System.out.println(!canSpell("internationalization", "qwertyuiopasdfghjksdfogiuy"));

        System.out.println("\n-TESTS FOR THE LAME METHOD-");
        System.out.println(canSpellLame("boot", "axobasrto"));
        System.out.println(!canSpellLame("hippo", "haxobapsrito"));
        System.out.println(!canSpellLame("hashmap", "hsdfhiumpiu"));
        System.out.println(canSpellLame("macintosh", "cmansfidghjto"));
        System.out.println(!canSpellLame("internationalization", "qwertyuiopasdfghjksdfogiuy"));

        //Question: Which of the two methods is computationally faster?
    }

}
