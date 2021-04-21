package Exs.easy;

/**
 * @author wy
 * @date 2021/3/28 17:59
 */
// 190. 颠倒二进制位
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res先往左移一位，把最后一个位置空出来，
            //用来存放n的最后一位数字
            res <<= 1;
            //res加上n的最后一位数字（这里改成加法）
            res += n & 1;
            //n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }
}
