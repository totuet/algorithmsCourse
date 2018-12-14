package section1_1;

//Write a recursive static method that computes the value of ln(N!)

public class ex1_1_20 {


    public static double fact(double N) {
        if (N == 1) return 1;
        return  N * fact(N-1);
    }

    public static void main(String[] args) {
        for (double i = 1; i < 20; i++) {
            System.out.println(i + "   " + Math.log(fact(i)));

        }

    }
}
