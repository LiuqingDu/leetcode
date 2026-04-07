/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        // 我们目标是找出一堆石头，其重量尽可能接近总重量的一半 sum / 2
        int target = sum / 2;

        // dp[j] 表示重量为 j 的背包，最多能装多少重量的石头
        // 这里的 j 就是你原代码中的 m
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            // 倒序遍历是为了保证每块石头只被使用一次（01背包核心）
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        // dp[target] 是最接近 sum/2 的那一堆石头的总重量
        // 另一堆的重量就是 sum - dp[target]
        // 两者的差值就是 (sum - dp[target]) - dp[target]
        return sum - 2 * dp[target];
    }
}
// @lc code=end

