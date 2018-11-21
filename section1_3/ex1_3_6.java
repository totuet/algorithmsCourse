package section1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
public class ex1_3_6 {

    /**
     * Created by Rene Argento
     */


        private static void invertQueue(Queue<String> queue) {
            Stack<String> stack = new Stack<>();

            while (!queue.isEmpty()) {
                stack.push(queue.dequeue());
            }

            while(!stack.isEmpty()) {
                queue.enqueue(stack.pop());
            }
        }

        public static void main(String[] args) {
            Queue<String> queue = new Queue<>();
            queue.enqueue("1");
            queue.enqueue("2");
            queue.enqueue("3");

            StdOut.print("Normal queue: ");
            for(String string : queue) {
                StdOut.print(string + " ");
            }
            invertQueue(queue);
            System.out.println();
            StdOut.print("Inverted queue: ");
            for(String string : queue) {
                StdOut.print(string + " ");
            }
            StdOut.println("\nExpected: 3 2 1");
        }

}

