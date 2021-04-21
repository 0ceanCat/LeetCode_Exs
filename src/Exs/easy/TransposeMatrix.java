package Exs.easy;

/**
 * WY 2021/2/24
 */
// 867. 转置矩阵
public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        transpose(new int[][]{{1,2,3}, {4,5,6}});
    }
}
