package Exs.hard;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/9/28 17:07
 */
// 517. 超级洗衣机
public class SuperWashingMachines {
    public static int findMinMoves(int[] machines) {
        int tot = 0;
        for (int num : machines){
            tot += num;
        }
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }

    public static void main(String[] args) {
        findMinMoves(new int[]{1,0,5});
    }
    
}
