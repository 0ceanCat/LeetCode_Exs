package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/19 17:38
 */

// 1877. 数组中最大数对和的最小值
public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        int n = nums.length;
        for (int i = 0, j = n - 1; i < n / 2 && j >= n / 2; i++, j--) {
            max = Math.max(nums[i] + nums[j], max);
        }

        return max;
    }


    static void test(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        test(new Object().toString());
    }
}
