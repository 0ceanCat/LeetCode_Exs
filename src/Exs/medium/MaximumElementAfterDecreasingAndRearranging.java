package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/7/14 17:51
 */
public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != res) res++;
        }

        return res;

    }


}
