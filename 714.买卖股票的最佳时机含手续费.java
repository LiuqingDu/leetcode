/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 这个跟没有手续费的买卖股票很像, 只需要额外考虑手续费即可
        // 因为如果要利润最大化,最后一天肯定是不持有股票的, 也就是只要买入那么必定卖出
        // 手续费只需要在卖出的时候扣掉就可以
        // 每一天有两个状态, 持有和不持有, 取决于前一天是否持有
        
        int n = prices.length;
        int[][] dp = new int[n][2];

        // 初始化第一天持有股票的资金为负数
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 今天如果不持有, 要么是昨天也没有, 要么是昨天有但今天卖了
            // 注意 dp 里存的是不包含股票本身的资金,已经扣除了股票成本, 所以直接用昨天的钱加上今天的售价即可
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 今天持有也是同理
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }
}
// @lc code=end

