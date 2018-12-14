package section1_1;
import java.util.*;

public class ex1_1_15 {
    public static void main(String[] args) {
        int[] inputArr = {1,6,7,9,4,6,3,1,3,5,1,7,6,8,9,8,7,6,3,1,3,2};
        int M = 9;
        int[] ret = histogram(inputArr, M);

        for (int i = 0; i < ret.length; i++) {
            System.out.println(i+1 +": " + ret[i]);
        }
    }


    public static int[] histogram(int[] a, int M) {
        int[] finalArr = new int[M];

        for (int i = 0; i < a.length; i++) {
            finalArr[a[i]-1]++;
        }
        return finalArr;
    }
}

