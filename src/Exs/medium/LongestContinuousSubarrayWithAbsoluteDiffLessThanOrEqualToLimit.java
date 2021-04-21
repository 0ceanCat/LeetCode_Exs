package Exs.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * WY 2021/2/21
 */
// 1438. 绝对差不超过限制的最长连续子数组
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int l = 0, r = 0, res = 0;
        while (r < nums.length) {
            while (!maxQueue.isEmpty() && nums[r] > maxQueue.peekLast())
                maxQueue.removeLast();
            while (!minQueue.isEmpty() && nums[r] < minQueue.peekLast())
                minQueue.removeLast();
            maxQueue.add(nums[r]);
            minQueue.add(nums[r]);
            r++;
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[l]) maxQueue.remove();
                if (minQueue.peek() == nums[l]) minQueue.remove();
                l += 1;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10,1,2,4,7,2};
        System.out.println(longestSubarray(a, 5));
    }
}
