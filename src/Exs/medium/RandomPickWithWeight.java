package Exs.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wy
 * @date 2021/8/29 17:54
 */
public class RandomPickWithWeight {
    int[] pre;
    int total;

    public RandomPickWithWeight(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = pre[w.length - 1];
    }
    Random random = new Random();
    public int pickIndex() {
        int x = random.nextInt(total) + 1;
        return binarySearch(x);
    }


    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        RandomPickWithWeight r = new RandomPickWithWeight(new int[]{1,2,3,4,5,6,7});
        r.pickIndex();
        r.pickIndex();
        r.pickIndex();
        r.pickIndex();
        r.pickIndex();
    }
}
