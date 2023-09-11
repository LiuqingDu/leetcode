/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    // 动态规划，定义dp[i]表示以nums[i]这个数字结尾的串，最大的子序列长度
    // 也就是说dp[i]的值，对应的串至少包含nums[i]这一个数字，所以长度至少为1
    // 那么dp[i]的值，取决于nums[i]前面有没有比nums[i]更小的数字，如果有，那么就可以跟nums[i]组成一个更长的串
    // 如果组成了，那么dp[i]就是这个长度+1，如果没有组成，dp[i]还是默认的1

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的串的最大子序列长度
        int[] dp = new int[n];
        // 子序列长度至少为1
        Arrays.fill(dp, 1);

        // 从第二个dp开始计算，因为第一个dp肯定是1不会变
        for (int i = 1; i < n; i++) {
            // 每个dp的值取决于nums[i]之前所有的数
            for (int j = 0; j < i; j++) {
                // 如果nums[i]前面有比它更小的数，那么就可以组成更长的串
                if (nums[j] < nums[i]) {
                    // 长度等于找到的前面的串长度+1，然后再取最大值
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        // dp[i]记录的是每一个以nums[i]结尾的串的最大子序列长度，
        // 本题要的结果是dp中的最大值
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;

    }
}
// @lc code=end

