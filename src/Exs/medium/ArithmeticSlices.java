package Exs.medium;

import java.util.Comparator;
import java.util.List;

/**
 * @author wy
 * @date 2021/8/9 21:29
 */
// 413. 等差数列划分
public class ArithmeticSlices implements Cloneable{
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int[] dp = new int[nums.length + 1];
        int c = 0;
        int diff = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff){
                c++;
            }else {
                c = 0;
                diff = nums[i] - nums[i - 1];
            }

            if (c >= 1){
                dp[i] = dp[i - 1] + c;
            }else{
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{1,2,3,4,5});
    }
}
