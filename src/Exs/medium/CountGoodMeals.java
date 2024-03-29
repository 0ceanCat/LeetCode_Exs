package Exs.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2021/7/7 16:34
 */
// 1711. 大餐计数
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        CountGoodMeals c = new CountGoodMeals();
        System.out.println(c.countPairs(new int[]{1, 3, 5, 7, 9}));
    }
}
