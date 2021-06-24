package Exs.hard;

/**
 * @author wy
 * @date 2021/5/12 19:54
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    /*
        private int MOD = 1_000_000_007;
        // 用哈希表记录访问过的状态
        private Map<String, Integer> mem = new HashMap<>();
        public int numWays(int steps, int arrLen) {
            return dp(steps, arrLen, 0);
        }
        private int dp(int steps, int arrLen, int pos) {
            // 递归终止条件，可走0步，若此时在原点则返回1
            if (steps == 0) { return pos == 0 ? 1 : 0;}

            String code = "" + steps + "," + pos;

            // 之前是否到达过这个状态，是的话直接返回
            if (mem.containsKey(code)) return mem.get(code);

            int ans = dp(steps-1, arrLen, pos);  // 原地不动

            //右移一步
            if (pos+1 < arrLen) { ans += dp(steps-1, arrLen, pos+1); ans %= MOD; }
            //左移一步
            if (pos-1 >= 0)     { ans += dp(steps-1, arrLen, pos-1); ans %= MOD; }

            // 记下当前状态，防止重复搜索
            mem.put(code, ans);

            return ans;
        }
     */

    /**
     * 方法二：动态规划
     * 分析
     * 根据方法一中的递推式，可以采用动态规划的方法解决问题
     * 当我们走第xx步时,假设我们的位置为pospos,那么这个位置只能由在x-1x−1步时,从pos-1或pos或pos+1pos−1或pos或pos+1各走+1, 0, -1+1,0,−1达到。
     * 动规方程： dp(x, pos) = dp(x-1, pos-1) + dp(x-1, pos) + dp(x-1, pos+1)dp(x,pos)=dp(x−1,pos−1)+dp(x−1,pos)+dp(x−1,pos+1)
     * 注意：在走xx步时，我们能到达最远的距离是xx和arrLenarrLen中的较小者。
     *
     * 作者：copyreadmachine
     * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/java-ji-yi-hua-sou-suo-jian-dan-yi-dong-by-copyrea/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    private static int MOD = 1_000_000_007;
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps+1][steps+1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            // 注意: steps = i 时，我们最远能走到的是 i 和 arrLen-1 的较小者
            for (int j = 0; j <= Math.min(i, arrLen-1); j++) {
                dp[i][j] = dp[i-1][j];
                if (j-1>=0) { dp[i][j] += dp[i-1][j-1]; dp[i][j] %= MOD; }
                if (j < i)  { dp[i][j] += dp[i-1][j+1]; dp[i][j] %= MOD; }
            }
        }
        return dp[steps][0];
    }

}
