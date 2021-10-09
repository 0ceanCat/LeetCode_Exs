package Exs.easy;


/**
 * @author wy
 * @date 2021/10/5 18:15
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3,2,1}));
    }
}
