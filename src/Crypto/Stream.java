package Crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class Stream
{
    //all this BS here is because we used to have 2 functions
    private final static int alphabet_length;
    private final static StringBuilder cipher_bldr;
    private static SecureRandom random;
    private final static char base_char;

    static {
        alphabet_length = (126 - 32) + 1;
        cipher_bldr = new StringBuilder();
        random = null;
        base_char = ' ';
    }

    private static void secureRandomDeclare()
    {
        try
        {
            random = SecureRandom.getInstance("SHA1PRNG");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void clearStringBuilder() { cipher_bldr.setLength(0); }

    public static String E(final String clear, final int key, final boolean encrypt)
    {
        clearStringBuilder();
        secureRandomDeclare();
        random.setSeed(key);

        for(int i = 0; i < clear.length(); i++)
        {
            final int shift;
            if(encrypt) shift = random.nextInt(100);
            else shift = -random.nextInt(100);
            System.out.println(shift);

            final int cipher_char_pos = Math.floorMod(clear.charAt(i) - base_char + shift, alphabet_length);
            final char cipher_char = (char) (cipher_char_pos + base_char);
            cipher_bldr.append(cipher_char);
        }
        
        return cipher_bldr.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(E("java", 20, true)); //encryption test
        System.out.println(E("/S&Y", 20, false));
    }
    
}
