package Exs.easy;

/**
 * @author wy
 * @date 2021/8/27 17:30
 */
// 1480. 一维数组的动态和
public class RunningSumOfOneDArray {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + res[i - 1];
        }
        return res;
    }
}
