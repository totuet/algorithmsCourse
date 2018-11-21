package section1_3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExpressionEvaluation {
    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        String expression = " ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ";


            for (String s : expression.split(" ")) {

                if (s.equals(")")) {
                    if (!operators.isEmpty() && operators.peek().equals("+")) {
                        operators.pop();
                        operands.push(operands.pop() + operands.pop());
                    }
                    if (!operators.isEmpty() && operators.peek().equals("*")) {
                        operators.pop();
                        operands.push(operands.pop() * operands.pop());
                    }
                    continue;
                }
                if (!s.equals("(")) {
                    try {
                        operands.push(Integer.parseInt(s));
                    } catch (NumberFormatException nfe) {
                        operators.push(s);
                    }


            }
        }



        System.out.println();
        System.out.print("Result: " + operands.peek());


    }
}
