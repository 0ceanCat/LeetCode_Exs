package Exs.medium;

/**
 * @author wy
 * @date 2021/3/29 17:33
 */
// 74 搜索二维矩阵
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int cols = matrix[0].length;
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while (l <= r){
            int m = (r + l) / 2;
            if (matrix[m / cols][m % cols] == target){
                return true;
            }else if (matrix[m / cols][m % cols] < target){
                l = m + 1;
            }else if (matrix[m / cols][m % cols] > target){
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{1}};
        System.out.println(searchMatrix(ints, 2));
    }
}
