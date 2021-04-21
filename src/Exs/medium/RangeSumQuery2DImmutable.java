package Exs.medium;

/**
 * @author wy
 * @date 2021/3/1 18:02
 */
// 304. 二维区域和检索 - 矩阵不可变
public class RangeSumQuery2DImmutable {
    public static class NumMatrix {
        private int[][] sum; // sum[i+1][j+1] = sumRegion(0,0,i,j)

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            int rows = matrix.length;
            int cols = matrix[0].length;
            sum = new int[rows + 1][cols + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5} };
        NumMatrix m = new NumMatrix(matrix);
        m.sumRegion(2, 1, 4, 3);
    }
}
