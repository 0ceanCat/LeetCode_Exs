package Exs.easy;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/5/3 18:25
 */
public class SumOfUniqueElements {
    public static int sumOfUnique(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]){
                res += nums[i];
            }else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        res += nums[nums.length - 1] == nums[nums.length - 2] ? 0 : nums[nums.length - 1];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }
}
