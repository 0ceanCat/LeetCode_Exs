package Exs.medium;

/**
 * @author wy
 * @date 2021/9/25 17:07
 */
// 371. 两整数之和

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
//010100 a
//011110 b
//001010 a ^ b              -> a
//101000 (a & b) << 1       -> b

//100010 a ^ b              -> a
//010000 (a & b) << 1       -> b

//110010 a ^ b              -> a
//000000 (a & b) << 1       -> b

//110010