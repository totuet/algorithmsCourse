package exercises01_01;
import edu.princeton.cs.algs4.*;

public class ex1_1_7 {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println("sum: " + sum);
        //dus som van eerste 999 natuurlijke nummers
        //cf. n(n+1)/2


//        int sum = 0;
//        for (int i = 1; i < 1000; i *= 2)
//            for (int j = 0; j < N; j++)
//                sum++;
//        StdOut.println(sum);
    }
}
