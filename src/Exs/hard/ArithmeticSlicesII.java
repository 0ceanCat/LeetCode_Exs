package Exs.hard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wy
 * @date 2021/8/10 19:13
 */
public class ArithmeticSlicesII {
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = (long) nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{2,4,6}));
        Stream<Integer> stream = List.of(1, 2, 3, 4, 5).stream().map(x -> x + 1);
        stream.collect(Collectors.toList());
    }
}
