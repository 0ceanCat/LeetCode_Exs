package Exs.medium;

import java.util.*;

/**
 * @author Wei
 * @date 2020/11/8 23:02
 * 973. 最接近原点的 K 个点
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt((array) -> array[0] * array[0] + array[1] * array[1]));
        return Arrays.copyOf(points, K);
    }

}
