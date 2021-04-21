package Exs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wy
 * @date 2021/3/14 16:08
 */

// 54. 螺旋矩阵
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        LinkedList<Integer> list = new LinkedList<>();

        int lines = matrix.length;
        int cols = matrix[0].length;
        int total = cols * lines - matrix[0].length;
        int lastL = 0, lastC = matrix[0].length - 1, d = 0;
        int[] lc = directions[d];
        boolean horizontal = false;
        int c = 0;
        while (list.size() != total){
            lastL += lc[0];
            lastC += lc[1];
            c++;
            list.add(matrix[lastL][lastC]);

            if (horizontal && c == cols - 1){
                cols--;
                lc = directions[++d % 4];
                horizontal = false;
                c = 0;
            }else if (!horizontal && c == lines - 1){
                lines--;
                lc = directions[++d % 4];
                horizontal = true;
                c = 0;
            }
        }

        for (int i = matrix[0].length - 1; i >= 0; i--) {
            list.addFirst(matrix[0][i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
