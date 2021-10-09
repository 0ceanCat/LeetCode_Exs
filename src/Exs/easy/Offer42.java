package Exs.easy;

/**
 * @author wy
 * @date 2021/7/16 17:47
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
