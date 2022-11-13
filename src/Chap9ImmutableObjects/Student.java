package Chap9ImmutableObjects;

public class Student {
    // Classes encapsulate related data

    // Private data cannot be accessed from outside the class
    private final String first; //instance variables
    private final String last;
    private final String id;

    String nickname;

    public Student(final String first, final String last, final String id, String nickname) {
        this.first = first;
        this.last = last;
        this.id = id;
        this.nickname = nickname;
    }

    public String toString() {
        return last + ", " + first + " (" + nickname + ")";
    }

}
