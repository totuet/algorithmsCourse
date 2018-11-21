package section1_2;

import edu.princeton.cs.algs4.*;

/*
Write an Interval1D client that takes an int value N as command-line argument,
reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect.
 */

public class ex1_2_2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervalArray = new Interval1D[N];
        In input = new In();

        for (int n = 0;  n < N ; n++) {

            double x = input.readDouble();
            double y = input.readDouble();
            if (x - y > 0) {
                System.out.println("second argument has to be larger than first");
                n--;
            } else {
            intervalArray[n] = new Interval1D(x, y);
            }
        }

            for (int i = 0; i < intervalArray.length ; i ++) {
                for (int j = i + 1; j < intervalArray.length ; j ++) {
                    if (intervalArray[i].intersects(intervalArray[j])) {
                        System.out.println("These intervals intersect:");
                        StdOut.println(intervalArray[i]);
                        StdOut.println(intervalArray[j]);

                    }
                }
            }
        }



}
