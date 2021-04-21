package Exs.easy;

/**
 * @author wy
 * @date 2021/2/28 20:29
 */
// 303. 区域和检索 - 数组不可变
public class RangeSumQueryImmutable {
    public static class NumArray{
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (; i <= j; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

}
