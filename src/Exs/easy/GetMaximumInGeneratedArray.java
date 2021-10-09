package Exs.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2021/8/22 21:10
 */
// 1646. 获取生成数组中的最大值
public class GetMaximumInGeneratedArray {

    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 0; nums[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            int k = nums[i] = (i & 1) == 0 ? nums[i >> 1] : nums[i >> 1] + nums[(i >> 1) + 1];
            if (k > max) max = k;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ns = new int[2];
        int n = Math.max(1, ns[1] = 2);
        System.out.println(n);
    }
}
