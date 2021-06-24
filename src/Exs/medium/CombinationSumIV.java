package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/23 19:02
 */
// 377. 组合总和 Ⅳ
public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (i >= x) {
                    dp[i] += dp[i - x];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        combinationSum4(new int[]{1,2,3,4}, 4);
    }
}
