/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {

        // dp[i]表示目标数为i的时候有多少种方案
        // 最终答案为dp[target]
        // 明显dp[0] = 1
        // 外层遍历目标数字target
        // 内层遍历nums每一个数字，当前数字j作为方案的最后一个数字来看有多少种方案
        // 那么dp[i]就等于dp[i] + dp[i - j]
        // 意思为，dp[i]是在原先基础上，加上以当前数字j作为最后一位的方案数
        // j作为最后一位的方案数就是目标值为【i减去j】的方案数

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i >= j) {
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }

        return dp[target];

    }
}
// @lc code=end

