package Crypto;

public final class Caesar
{
    private final static int alphabet_length;
    private final static StringBuilder cipher_bldr;

    static {
        alphabet_length = 26;
        cipher_bldr = new StringBuilder();
    }

    private static void clearStringBuilder() { cipher_bldr.setLength(0); }

    public static String E(final String clear, final int key)
    {
        clearStringBuilder();

        for(int i = 0; i < clear.length(); i++)
        {
            final int cipher_char_pos = Math.floorMod(clear.charAt(i) - 'a' + key, alphabet_length);
            final char cipher_char = (char) (cipher_char_pos + 'a');
            cipher_bldr.append(cipher_char);
        }
        
        return cipher_bldr.toString();
    }

    public static String D(final String cipher, final int key)
    {
        clearStringBuilder();

        for(int i = 0; i < cipher.length(); i++)
        {
            final int cipher_char_pos = Math.floorMod(cipher.charAt(i) - 'a' - key, alphabet_length);
            final char cipher_char = (char) (cipher_char_pos + 'a');
            cipher_bldr.append(cipher_char);
        }

        return cipher_bldr.toString();
    }

    public static String D_cheesy(final String cipher, final int key)
    {
        return E("cold", -key);
    }

    public static void main(String[] args)
    {
        System.out.println(E("cold", 20).equals("wifx")); //encryption test
        System.out.println(D("wifx", 20).equals("cold")); //decryption test
        System.out.println(D(E("cold", 20), 20).equals("cold"));
        System.out.println(D_cheesy(E("cold", 20), 20).equals("cold"));
    }
    
}
