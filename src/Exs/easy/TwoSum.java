package Exs.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wei
 * @date 2020/10/3 11:04
 * 1. 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]),i};
            map.put(nums[i], i);
        }
        return null;
    }
}
