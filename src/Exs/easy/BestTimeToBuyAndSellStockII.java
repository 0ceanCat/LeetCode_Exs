package Exs.easy;

/**
 * @author Wei
 * @date 2020/11/7 16:20
 * 122. 买卖股票的最佳时机 II
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                if (diff > 0) {
                    maxProfit += diff;
                }
        }

        return maxProfit;
    }
}
