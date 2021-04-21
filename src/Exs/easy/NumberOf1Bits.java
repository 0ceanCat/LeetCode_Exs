package Exs.easy;

/**
 * @author wy
 * @date 2021/3/21 17:56
 */

// 191. 位1的个数
public class NumberOf1Bits {
    public int hammingWeight(int n) {

        int countx = 0;
        while(n != 0) {
            countx++;
            n = n & (n-1);
        }
        return countx;
    }


    public static void main(String[] args) {
        NumberOf1Bits s = new NumberOf1Bits();
        System.out.println(s.hammingWeight(3));
    }
}
