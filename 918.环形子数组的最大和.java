/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int total = 0;

        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            // 最大子数组和（Kadane）
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            // 最小子数组和
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            total += num;
        }

        // 全是负数
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }
}
// @lc code=end

