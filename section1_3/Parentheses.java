package section1_3;

import edu.princeton.cs.algs4.*;

import java.util.Stack;
import java.util.stream.Stream;

//Write a stack client Parentheses that reads in a text stream from standard input
//and uses a stack to determine whether its parentheses are properly balanced. For example,
//your program should print true for [()]{}{[()()]()} and false for [(]).

public class Parentheses {
    public static void main(String[] args)   {
        //String input = StdIn.readLine();


        System.out.println("Is [()]{}{[()()]()} balanced: " + checkParentheses("[()]{}{[()()]()}"));
        System.out.println("Is [(]) balanced: " + checkParentheses("[(])"));

    }

    public static boolean checkParentheses (String input) {
        Stack<Character> parentheses = new Stack<>();
        char[] chararray = input.toCharArray();
        for (char s : chararray) {

            if (s == '[' ||  s == '{' ||  s == '('  ) {
                parentheses.push(s);

            } else {
                if (parentheses.isEmpty()) return false;

                char firstItem = parentheses.pop();

                if  (s == ')' && firstItem != '('
                        || s == ']' && firstItem != '['
                        || s == '}' && firstItem != '{') return false;

            }
        }
        return true;
    }
}
