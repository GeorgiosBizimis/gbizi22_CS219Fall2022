package Crypto;

import java.util.Random;

public final class Stream
{
    private final static int alphabet_length;
    private final static StringBuilder cipher_bldr;
    private final static Random random;
    
    static {
        alphabet_length = 26;
        cipher_bldr = new StringBuilder();
        random = new Random();
    }

    private static void clearStringBuilder() { cipher_bldr.setLength(0); }

    public static String E(final String clear, final int key)
    {
        clearStringBuilder();

        random.setSeed(key);

        for(int i = 0; i < clear.length(); i++)
        {
            final int shift = random.nextInt(100);
            System.out.println(shift);
            final int cipher_char_pos = Math.floorMod(clear.charAt(i) - 'a' + shift, alphabet_length);
            final char cipher_char = (char) (cipher_char_pos + 'a');
            cipher_bldr.append(cipher_char);
        }
        
        return cipher_bldr.toString();
    }

    public static String D(final String cipher, final int key)
    {
        clearStringBuilder();

        random.setSeed(key);

        for(int i = 0; i < cipher.length(); i++)
        {
            final int shift = random.nextInt(100);
            System.out.println(shift);
            final int cipher_char_pos = Math.floorMod(cipher.charAt(i) - 'a' - shift, alphabet_length);
            final char cipher_char = (char) (cipher_char_pos + 'a');
            cipher_bldr.append(cipher_char);
        }

        return cipher_bldr.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(E("java", 20)); //encryption test
        System.out.println(D("kkwj", 20)); //decryption test
    }
    
}
