package exercises01_01;

//Write a program that reads in lines from standard input with each
// line containing a name and two integers and then uses printf()
// to print a table with a column of the names, the integers,
// and the result of dividing the first by the second, accurate to
// three decimal places.

import edu.princeton.cs.algs4.StdIn;

public class ex1_1_21 {
    public static void main(String[] args) {
        double res1;
        double res2;
        String name;
        while (StdIn.hasNextLine()) {
            String a = StdIn.readLine();
            String[] strArr = a.split(" ");
            name = strArr[0];
            res1 = Integer.parseInt(strArr[1]);
            res2 = Integer.parseInt(strArr[2]);
            System.out.printf("%s: | %6.3f | %6.3f | %6.3f %n",name, res1, res2, res1/res2);

        }
    }
}
