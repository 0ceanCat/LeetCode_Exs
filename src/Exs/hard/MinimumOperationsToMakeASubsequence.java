package Exs.hard;

import java.util.*;

/**
 * @author wy
 * @date 2021/7/25 21:27
 */
// 1713. 得到子序列的最少操作次数
public class MinimumOperationsToMakeASubsequence {
    public int minOperations(int[] target, int[] arr) {
        // 第一步，把target中的所有值对应的索引存到哈希表中
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < target.length; i++) {
            hashMap.put(target[i], i);
        }
        // 第二步，把arr中在target数组存在的数字的索引按顺序排列到新的数组中
        int index = 0;
        int[] indexArray = new int[arr.length];
        Arrays.fill(indexArray, -1); // 初始填充-1
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                indexArray[index++] = hashMap.get(arr[i]);
            }
        }
        // 如果都为-1，代码arr中没有target中的整数，返回target长度
        if (indexArray[0] == -1) return target.length;
        // 第三步，计算indexArray中的最长递增子序列，这里直接套用 300. 最长递增子序列 题目的官方解法；
        int num = lengthOfLIS(indexArray);

        return target.length - num;
    }

    private int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeASubsequence m = new MinimumOperationsToMakeASubsequence();
        m.minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1});
    }
}
