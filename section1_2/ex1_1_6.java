package section1_2;
/*
string s is a circular rotation of a string t if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
sequences. Write a program that checks whether two given strings s and t are circular
shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
string concatenation.
 */

public class ex1_1_6 {
    public static void main(String[] args) {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";

        System.out.println(isCircular(s1, s2)); //expected true

        s1 = "HELLO";
        s2 = "OLLEH";

        System.out.println(isCircular(s1, s2)); //expected false


    }

    public static boolean isCircular(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
