package Chap9ImmutableObjects;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellmen {

    public static void main(String[] args)
    {
        // Get a big prime number
        BigInteger p = new BigInteger("7919");
        // p = new BigInteger()
        BigInteger aPriv = new BigInteger("123456789");

        // Alice compute here public key
        BigInteger aPub = BigInteger.TWO.modPow(aPriv, p);

        // Send Bob the public key


        // Bob picks private key
        BigInteger bPriv = new BigInteger("497");

        // Bob computes his public key
        BigInteger bPub = BigInteger.TWO.modPow(bPriv, p);

        // Alice can now compute the shared key
        BigInteger aShared = bPub.modPow(aPriv, p);

        //Bob can compute the shared key
        BigInteger bShared = aPub.modPow(bPriv, p);

        System.out.println(aShared);
        System.out.println(bShared);
    }

}
