/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robSub(Arrays.copyOfRange(nums, 0, n - 1)), robSub(Arrays.copyOfRange(nums, 1, n)));
    }

    private int robSub(int[] nums) {
        int n = nums.length;
        // 在 lc198 基础上省略去对于n==1和n==2的判断
        // 创建dp的时候多创建两个位置，从第三个开始真正的dp，
        // 前两个用0填充，这样并不影响Math.max()的结果
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
            // 相当于dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
            // 相当于把上面注释里的dp往右移动两格，这样避免了负数指针
        }
        return dp[n + 1];
    }
}
// @lc code=end

