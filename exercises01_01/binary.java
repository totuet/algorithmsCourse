package exercises01_01;

public class binary {
    public static void main(String[] args) {
        int N = 5;
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
    }
}

