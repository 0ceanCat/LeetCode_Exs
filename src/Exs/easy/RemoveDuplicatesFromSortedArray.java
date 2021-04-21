package Exs.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wy
 * @date 2021/4/17 17:07
 */
// 26. 删除有序数组中的重复项
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0, l = 0;
        while (i < nums.length){
            nums[l] = nums[i++];
            while(i < nums.length && nums[i] == nums[l]){
                i++;
            }
            l++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
