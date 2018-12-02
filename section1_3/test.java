package section1_3;

public class test {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int count = 1;
        System.out.println(arr[++count -1]);
        System.out.println(count);
    }
}
