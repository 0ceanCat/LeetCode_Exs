package Exs.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wy
 * @date 2021/8/14 18:18
 */
public class OutOfBoundaryPaths {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m + 1][n + 1][maxMove + 1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
       return check(m, n, maxMove, startRow, startColumn, dp);
    }

    private int check(int m, int n, int move, int y, int x, int[][][] dp) {
        if (y < 0 || y >= m || x < 0 || x >= n ) return 1;

        if (dp[y][x][move] != -1) return dp[y][x][move];

        if (move == 0) return 0;

        int res = 0;

        for (int[] dir : dirs) {
            res += check(m, n, move - 1 , y + dir[0], x + dir[1], dp);
            res %= MOD;
        }
        dp[y][x][move] = res;
        return res;
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths o = new OutOfBoundaryPaths();
        System.out.println(o.findPaths(1,3, 3, 0, 1));
    }
}
