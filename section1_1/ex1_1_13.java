package section1_1;
import java.util.Random;

public class ex1_1_13 {
    public static void main(String[] args1) {
        int[][] arr = new int[10][10];
        int[][] arr2 = new int[10][10];
        Random rand = new Random();

        //random vullen van array
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr[i].length ; j++) {
                arr[i][j] = rand.nextInt(50);
            }
        }
        //array printen vóór swap
        for (int[] row: arr) {
            for (int el: row) {
                System.out.printf("%6d", el);
            }
            System.out.println();
        }
        System.out.println();

        //kopieren van array
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr[i].length ; j++) {
                    arr2[j][i] = arr[i][j];
                    arr2[i][j] = arr[j][i];
            }
        }
        for (int[] row: arr2) {
            for (int el: row) {
                System.out.printf("%6d", el);
            }
            System.out.println();
        }
    }
}
