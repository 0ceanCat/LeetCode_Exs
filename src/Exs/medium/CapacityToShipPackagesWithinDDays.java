package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/4/25 18:55
 */

// 1011. 在 D 天内送达包裹的能力
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int max = -1;
        for (int weight : weights) {
            max = Math.max(weight, max);
        }

        int lo = max, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
    private boolean canShip(int[] weights, int D, int K) {
        int cur = K; // cur 表示当前船的可用承载量
        for (int weight: weights) {
            if (weight > K) return false;
            if (cur < weight) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0; // 能否在D天内运完
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
        c.shipWithinDays(new int[]{1,2,3,1,1}, 4);
    }
}
