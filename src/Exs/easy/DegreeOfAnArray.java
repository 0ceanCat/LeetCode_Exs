package Exs.easy;

import java.util.*;

/**
 * WY 2021/2/19
 */
// 697. 数组的度
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length, degree = 0;
        Map<Integer, Integer> map = new HashMap<>(len);

        // 计算原数组的频数
        for (int i = 0; i < len; i++) {
            degree = Math.max(degree, map.merge(nums[i], 1, Integer::sum));
        }

        map.clear();
        int left = 0, right = 0, curDegree = 0, res = len;
        while (right < len) {
            // 计算当前滑窗内子数组的频数
            curDegree = Math.max(curDegree, map.merge(nums[right++], 1, Integer::sum));

            // 频数一致的情况
            if (curDegree == degree) {
                while (map.merge(nums[left], -1, Integer::sum) != degree - 1) {
                    left++;
                }
                curDegree = degree - 1;
                res = Math.min(res, right - left);
            }

        }
        return res;
    }

}
