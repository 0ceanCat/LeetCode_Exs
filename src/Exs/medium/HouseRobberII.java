package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/14 19:18
 */
// 213. 打家劫舍 II
public class HouseRobberII {
    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private static int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    // [2, 3, 3, 1, 1]
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 3, 1, 1}));
    }
}
