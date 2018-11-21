package exercises01_01;

/*
Random matches. Write a BinarySearch client that takes an int value T as
command-line argument and runs T trials of the following experiment for N = 10ˆ3, 10ˆ4,
10ˆ5, and 10^6: generate two arrays of N randomly generated positive six-digit int values,
and find the number of values that appear in both arrays. Print a table giving the average
value of this quantity over the T trials for each value of N.
 */

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class ex1_1_39 {
    public static void main(String[] args) {
        int N = 10000;
        int T = 10;
        int avg = 0;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        Counter counter = new Counter("Number of values that appear in both arrays");

        fillArray(arr1);
        fillArray(arr2);
        System.out.println(arr1.length);

        avg = checkForSameElements(arr1, arr2, counter, T);
        System.out.println(avg);
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = StdRandom.uniform(100000, 1000000);
        }
    }

    public static int checkForSameElements(int[] arr1, int[] arr2, Counter cntr, int T) {
        for (int x = 0; x < T; x++) {
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    if (arr1[i] == arr2[j]) {
                        cntr.increment();

                    }

                }
            }

        }
        return cntr.tally()/T;
    }

}
