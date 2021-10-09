package Exs.hard;

/**
 * @author wy
 * @date 2021/8/12 19:40
 */
// 233. 数字 1 的个数
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        int num = n;
        long i = 1;
        int s = 0;
        while(num > 0)
        {
            if(num % 10 == 0) // 不包含1 -9
                s += (num / 10) * i; // 修正值是 0

            if(num % 10 == 1) // 包含 1 - 9的一部分
                s += (num / 10) * i + (n % i) + 1; // 修正值是(n % i) + 1

            if(num % 10 > 1) // 包含1 - 9
                s += (num / 10) * i + i; // i

            num /= 10; // 比如109/10 = 10， 可以按10位的处理，因为i增量了10倍
            i *= 10; // 每次1的个数是增加10倍
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(210));
    }
}
