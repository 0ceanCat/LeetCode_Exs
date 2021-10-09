package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/8/2 17:25
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0;

        int[] sorted = Arrays.stream(nums).sorted().toArray();

        int l = 0 , r = nums.length - 1;

        while(l < r){
            if (sorted[l] != nums[l] && sorted[r] != nums[r]) break;

            if (sorted[l] == nums[l]) l++;

            if (sorted[r] == nums[r]) r--;
        }

        return l == r ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{1,2,3,3,3,3});
    }
}
