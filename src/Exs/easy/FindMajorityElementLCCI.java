package Exs.easy;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/8 18:11
 */
// 面试题 17.10. 主要元素
public class FindMajorityElementLCCI {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;
    }
}
