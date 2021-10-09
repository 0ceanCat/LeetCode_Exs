package Exs.easy;

/**
 * @author wy
 * @date 2021/8/7 17:06
 */
public class N_thTribonacciNumber {
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;

    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
