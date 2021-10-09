package Exs.easy;

import java.util.HashMap;

/**
 * @author wy
 * @date 2021/9/22 17:39
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n != 1){
            if (n % 3 != 0) return false;
            n /= 3;
        }

        return true;

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        PowerOfThree p = new PowerOfThree();
        //System.out.println(p.isPowerOfThree(1));
        System.out.println(gcd(15, 10));
    }
}
