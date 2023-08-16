/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {

    // 回溯方法可以做，但是会超时，这里用动态规划
    // 定义dp[i][j]表示使用前i个硬币，组成总值为j，共有多少种方案
    // 那么对于硬币i，有两种选择，要么使用该硬币，要么不使用该硬币，最终的dp[i][j]取决于这两个值的和
    // - 不使用：那么dp[i][j]等于dp[i-1][j]，也就是该硬币之前的那些硬币组成总额j的方案
    // - 使用：那么dp[i][j]应当等于dp[i][j-coins[i]],也就是使用该硬币的情况下,凑出(j-该硬币面值)的所有方案
    public int change(int amount, int[] coins) { 
        int n = coins.length;
        // 坐标从0开始，所以初始化数组要+1
        int[][] dp = new int[n + 1][amount + 1];

        // base case. 总额为0那么方案数固定为1：不拿任何硬币
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 循环计算每种可能
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 假设选择一枚当前面额的硬币，那么剩下的面额如果大于等于零，说明当前硬币是可以选的方案
                // 在可选当前硬币的情况下，总方案数量取决于【不选择当前硬币】+【选择当前硬币】
                // 也就是【不选择：dp[i-1][j]】+【选择：dp[i][j-coins[i-1]]】
                // 这里在coins里取了i-1而不是i，是因为初始化dp时+1导致的索引偏移
                // coins里第一枚硬币的索引是0，但dp[1]表示选择第1枚硬币，这两个数组的坐标相差1
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    // 如果剩下的面额小于零，说明当前面额的硬币不能选，否则总面额就超出目标面额了
                    // 不能选的情况下，就等于dp[i-1][j]，也就是不选当前硬币，但组成面额j的方案数
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
// @lc code=end

