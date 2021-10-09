package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/7 17:05
 */
// 930. 和相同的二元子数组
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
            System.out.println("sum: " + sum + ", ret: " + ret + ", num: " + num + ", c: " + cnt.get(sum));
        }
        return ret;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum b = new BinarySubarraysWithSum();
        System.out.println(b.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
