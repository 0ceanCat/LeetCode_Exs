package Exs.medium;

import java.util.TreeSet;

/**
 * @author wy
 * @date 2021/4/16 17:22
 */
public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove((long)nums[i - k - 1]);
            }
            Long low = set.ceiling((long) nums[i] - t);
            //是否找到了符合条件的数
            if (low != null && low <= (long)nums[i] + t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
   //     System.out.println(containsNearbyAlmostDuplicate(new int[]{4, 1, -1, 6, 5}, 3, 1));
        Integer.parseInt(Integer.MAX_VALUE+"");
    }
}
