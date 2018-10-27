package exercises01_01;
import java.util.*;

public class ex1_1_11 {
    public static void main(String[] args) {
        boolean[][] boolArr = new boolean[5][5];

        Random rand = new Random();
        int[] randArr = new int[25];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = rand.nextInt(10);
        }


        for (int i = 0 ; i < boolArr.length ; i++ ) {
            for (int j = 0 ; j < boolArr[i].length ; j++) {
                if((randArr[i + j] % 2) == 0) {
                    boolArr[i][j] = true;
                    System.out.println(boolArr[i][j]);
                } else {
                    boolArr[i][j] = false;
                }
            }
        }

        for (int i = 0; i < boolArr.length; i++) {
            for (int j = 0; j < boolArr[i].length; j++) {
                if (boolArr[i][j] == true) {
                    System.out.print("*");
                } else {
                    System.out.print("/");
                }
            }
            System.out.println();
        }
    }
}
