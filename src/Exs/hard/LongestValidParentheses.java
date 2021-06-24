package Exs.hard;

import java.util.Stack;

/**
 * @author wy
 * @date 2021/4/22 22:27
 */
// 32. 最长有效括号
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int size = s.length();
        int[] dp = new int[size];

        int maxVal = 0;
        for(int i = 1; i < size; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if ((i - dp[i - 1] - 2) >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        longestValidParentheses("()(()");
    }
}
