package Exs.hard;

/**
 * @author wy
 * @date 2021/9/10 17:10
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {
    static int fib(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 2;
        int a = 1;
        int b = 2;
        int c = 3;
        int i = n - 2;
        while(i-- > 0) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }

    static int findIntegers(int num) {
        if (num == 0) return 1;
        if (num == 1) return 2;
        int nbits = 0;
        while(num >> nbits > 0) {
            ++nbits;
        }

        if (num>>(nbits - 2) == 3) {
            return fib(nbits);
        } else {
            int mask = (1 << (nbits - 1)) - 1;
            return fib(nbits - 1) + findIntegers(num & mask);
        }
    }

    public static void main(String[] args) {
        System.out.println(findIntegers(10));
    }
}
