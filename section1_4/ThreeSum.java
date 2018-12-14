package section1_4;
//code straight from Algorithms by Sedgewick and Wayne

import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ThreeSum
{
    public static int count(int[] a)
    { // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }
    public static void main(String[] args) throws Exception
    {
        File file = new File("/Users/Tomvdb/Java/algorithms_sedgewick/section1_4/1Mints.txt");
        BufferedReader b = new BufferedReader(new FileReader(file));

        String readLine = "";

        int[] a = new int[1000000];
        int count = 0;

        while ((readLine = b.readLine()) != null) {
            a[count++] = Integer.parseInt(readLine.trim());
        }

        StdOut.println(count(a));

    }
}