/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    // 动态规划，定义dp[i]表示目标金额为i时，需要的最少的硬币数量
    public int coinChange(int[] coins, int amount) {

        // dp的尺寸为amount+1，因为最终需要dp[amount]这个索引表示答案
        int[] dp = new int[amount + 1];
        // 初始化dp的值，不初始化为MAX_VALUE的原因是后面有dp[i - coin]+1，这时候会溢出
        // 使用一个不可能的值就行，比如amount+1，因为最多只需要amount个硬币（全为1）
        Arrays.fill(dp, amount + 1);
        // base case, 金额为0的时候，硬币数为0
        dp[0] = 0;

        // 计算每个amount目标金额
        for (int i = 0; i < dp.length; i++) {
            // 遍历所有可能，也就是尝试先选一枚硬币，剩下的金额的硬币数+1就是当前方案的硬币数
            for (int coin: coins) {
                // 如果目标金额比当前硬币小，那么就无法组成方案，跳过
                if (i < coin) {
                    continue;
                }
                // 当前方案的硬币数量取决于【（减去当前硬币后剩余金额）的硬币数】再加一
                // 算出当前硬币的方案结果后，与已保存的dp[i]取小值
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // dp[amount]就是最终结果，如果这个值没有变化，说明无法凑出，否则就是最终结果
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end

