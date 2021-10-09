package Exs.medium;

import java.util.*;

/**
 * @author wy
 * @date 2021/9/12 17:29
 */
// 447. 回旋镖的数量
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer>[] maps = new Map[points.length];

        for (int i = 0; i < points.length; i++) {
            maps[i] = new HashMap<>();
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int k = i + 1; k < points.length; k++){
                int dx = points[i][0] - points[k][0];
                int dy = points[i][1] - points[k][1];
                int distance = dx * dx + dy * dy;
                Integer v1 = maps[k].compute(distance, (x, v) -> {
                    if (v == null) v = 0;
                    return v + 1;
                });

                if (v1 >= 2){
                    res += (v1 - 1) * 2;
                }

                Integer v2 = maps[i].compute(distance, (x, v)->{
                    if (v == null) v = 0;
                    return v + 1;
                });

                if (v2 >= 2){
                    res += (v2 - 1) * 2;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        NumberOfBoomerangs n = new NumberOfBoomerangs();
        n.numberOfBoomerangs(new int[][]{{0,0}, {1,0}, {2,0}});
    }
}
// 2 3 4 5 6
// 2 6 12 20 30