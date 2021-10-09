package Exs.easy;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/15 17:40
 */
// 剑指 Offer 53 - I. 在排序数组中查找数字 I
public class Offer53 {
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;

        if (i > 1 && nums[i - 1] != target) {
            return 0;
        }
        // 搜索左边界 right
        i = 0;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }


    public static void main(String[] args) {
        Offer53 a = new Offer53();
        System.out.println(a.search(new int[]{5,7,7,8,8,8,10}, 8));
    }
}