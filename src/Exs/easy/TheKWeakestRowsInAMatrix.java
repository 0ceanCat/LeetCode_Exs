package Exs.easy;

import java.util.Comparator;
import java.util.IllegalFormatCodePointException;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2021/7/31 18:19
 */
// 1337. 矩阵中战斗力最弱的 K 行
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int c = 0;
            for (int n : mat[i]) {
                if (n == 1){
                    c++;
                }else {
                    break;
                }
            }
            queue.add(new int[]{c, i});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[1];
        }

        return res;
    }
}
