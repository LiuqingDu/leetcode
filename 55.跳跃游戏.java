/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                break;
            }
            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                dp[i + j] = true;
            }
        }

        return dp[n - 1];

    }
}
// @lc code=end

