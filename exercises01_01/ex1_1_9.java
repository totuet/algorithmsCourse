package exercises01_01;


public class ex1_1_9 {
    public static void main(String[] args) {
        double N = 16;
        int M = (int) N; //om later te vergelijken met ToBinaryString
        System.out.println(M);
        double macht = 0;
        int plaats;
        int[] binArr = new int[16]; // max 32 bits waarden


        while (N > 0) {
            if (N / Math.pow(2, macht) < 1) {
                N = N - Math.pow(2, macht - 1);
                plaats = binArr.length - (int) macht;
                binArr[plaats] = 1;
                macht = 0;
            } else {
                macht++;
            }

        }
        for (int n: binArr) {
            System.out.print(n);
        }

        System.out.println();
        System.out.println(Integer.toBinaryString(M));

    }
}
