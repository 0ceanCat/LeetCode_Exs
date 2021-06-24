package Exs.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wy
 * @date 2021/4/30 9:56
 */
// 137. 只出现一次的数字 II
public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]){
                if (i == 0 || nums[i] != nums[i - 1])
                    return nums[i];
            }

        }

        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
    }
}
