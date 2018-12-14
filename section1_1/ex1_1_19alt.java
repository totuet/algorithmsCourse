package section1_1;

public class ex1_1_19alt {

    public static void main(String[] args) {
        double[] fibArr = new double[100];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i = 2; i < 100; i++) {
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
            System.out.println(i + ": " + fibArr[i]);
        }
    }
}
