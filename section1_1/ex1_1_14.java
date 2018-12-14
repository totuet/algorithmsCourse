package section1_1;

/*
* y = log2(N)
* 2ˆy = N
* we gaan y laten verhogen totdat 2ˆy dichtbij N komt
 */

public class ex1_1_14 {
    public static int ln(int N) {
        int y;
        int res = 2;

        if (N == 0) {
            return 1;
        } else if (N == 1) {
            return 2;
        }

        for ( y = 2 ; y < 40 ; y++) {
            res *= 2;
            if (N == res) {
                break;
            } else if (N - res < 0.01) {
                --y;
                break;
            }
        }
        return y;
    }

    public static void main(String[] args) {
        int res = ln(2047);
        System.out.println(res);
    }
}
