package section1_2;


import edu.princeton.cs.algs4.*;

public class VisualAccumulatorApp  {
    public static void main(String[] args)
    {
        int T = Integer.parseInt("10000");
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
