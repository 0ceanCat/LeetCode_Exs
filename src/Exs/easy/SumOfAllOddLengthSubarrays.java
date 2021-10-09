package Exs.easy;

/**
 * @author wy
 * @date 2021/8/28 17:12
 */
// 1588. 所有奇数长度子数组的和
public class SumOfAllOddLengthSubarrays {
    int res = 0;
    public int sumOddLengthSubarrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, i, 1, arr[i]);
        }
        return res;
    }

    private void dfs(int[] odds, int i, int c, int s) {
        if (i > odds.length) return;

        if ((c & 1) == 1) res += s;

        if (i + 1 < odds.length) dfs(odds, i + 1, c + 1, s + odds[i + 1]);
    }
}
