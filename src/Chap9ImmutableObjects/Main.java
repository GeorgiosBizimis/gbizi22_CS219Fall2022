package Chap9ImmutableObjects;

import javax.crypto.spec.ChaCha20ParameterSpec;

public class Main
{

    public static void main(String[] args)
    {
        //OBJECT ORIENTED PROGRAMMING
        final String s = "hello";
        final String t = new String("hello"); //calling the constructor
        //the constructor is a function that builds an object (instance of a class)
        //class <-- template for building an object
        //Strings in java are immutable

        //Make a version of s that is capitalized
        final String s1 = Character.toUpperCase(s.charAt(0)) + s.substring(1);

        //StringBuilder - mutable strings

        //Character object are also immutable
        char ch = 'a'; //a primitive type has a direct representation of binary 0, 1
        Character ch2 = 'a';
        //Character ch3 = new Character('a');

        int x = 33;
        Integer y = 33;
        //Integer y2 = new Integer(33);

        // Objects contain instance data along with operations (instance methods) on that instance data.

        double pi = 3.141559;
        Double pi2 = 3.141559;
        Boolean flag = false;
        Long ll = 43L;
        pi2 = 2.7128; // reassigning the reference

        // Double, Long, Integer, Boolean, Character, ... are all wrapper classes
        // for their respective primitive type.
        // Taking a primitive value and wrapping it in an object is autoboxing.
        // Turning an object into its primitive is called autounboxing.

        Student student1 = new Student("Hermione", "Ranger", "123", "Smartass");
        // student1.first = "Harry"; error
        // student1.nickname = ""; // remove Hermione's nickname
        System.out.println(student1); // toString is implicitly called

        Student student2 = new Student("Leonard", "Trotsky", "1234567890", "ChineseGamerXXX64");
        System.out.println(student2);
    }

}
