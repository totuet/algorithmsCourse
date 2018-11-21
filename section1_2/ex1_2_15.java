package section1_2;

/*
File input. Develop a possible implementation of the static readInts() method
from In (which we use for various test clients, such as binary search on page 47) that
is based on the split() method in String.
 */

public class ex1_2_15 {


    public static int[] readInts(String input) {
        String[] parsedInput = input.split("\\s+" );
        int[] intinput = new int[parsedInput.length];
        for (int i = 0; i < parsedInput.length ; i++) {
            intinput[i] = Integer.parseInt(parsedInput[i]);
        }
        return intinput;
    }
}
