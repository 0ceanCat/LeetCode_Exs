package Exs.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wei
 * @date 2020/11/11 22:41
 * 922. 按奇偶排序数组 II
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int[] res = new int[A.length];

        for (int value : A) {
            if ((value & 0x01) == 1) {
                res[odd] = value;
                odd += 2;
            } else {
                res[even] = value;
                even += 2;
            }
        }
        return res;
    }
}
