package section1_2;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/*
Instrument BinarySearch (page 47) to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are complete.
Hint : Create a Counter in main() and pass it as an argument to rank().
 */

public class ex1_2_9 {

    public static int rank(int key, int[] a) {
        // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Counter counter = new Counter("Total number of keys examined");
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            // Read key, print if not in whitelist.
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}


