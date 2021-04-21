package Exs.medium;

import java.util.Arrays;

/**
 * @author wy
 * @date 2021/3/20 17:26
 */
//73. 矩阵置零
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        s.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
