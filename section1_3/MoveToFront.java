package section1_3;

/*
1.3.40 Move-to-front. Read in a sequence of characters from standard input and
maintain the characters in a linked list with no duplicates.
When you read in a previously unseen character, insert it at the front of the list.
When you read in a duplicate character, delete it from the list and reinsert it at the beginning.
Name your program MoveToFront: it implements the well-known move-to-front strategy, which is useful for
caching, data compression, and many other applications where items that have been
recently accessed are more likely to be reaccessed.
 */

import edu.princeton.cs.algs4.StdIn;

import java.util.LinkedList;

public class MoveToFront {

    public static void main(String[] args) {
        LinkedList<Character> charList = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            char temp = StdIn.readChar();
            if (!charList.contains(temp)) {
                charList.add(temp);
                charList.forEach(System.out::print);
                System.out.println();
            } else {
                charList.remove(charList.indexOf(temp));
                charList.add(temp);
                charList.forEach(System.out::print);
                System.out.println();
            }
        }
    }
}
