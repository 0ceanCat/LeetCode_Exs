package Exs.medium;

import java.util.LinkedList;

/**
 * @author wy
 * @date 2021/9/18 17:14
 */
// 650. 只有两个键的键盘
public class KeysKeyboard {
    public static int minSteps(int n) {
        if (n == 1) return 0;
        int[] dp = {1, 1};
        int i = 1;
        while (dp[0] != n){
            if ( (n - dp[0]) % dp[0] == 0 && dp[1] < dp[0])
                dp[1] = dp[0];
            else
                dp[0] += dp[1];
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(minSteps(15));
    }
}
