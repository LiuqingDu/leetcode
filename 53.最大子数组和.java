/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    // 动态规划
    // 很容易想到定义dp[i]表示前i个数字中最大的子数组和，但是这时我们很难通过
    // dp[i-1]来计算dp[i], 因为dp[i-1]的子数组和，可能是nums[i-1]之前数字里，前部或者中部的子数组
    // 也就是说，nums[i]可能跟dp[i-1]对应的那个数组并不是相连的，那么这样就无法把dp[i-1]和dp[i]联系起来了
    // 换个思路，定义dp[i]表示以nums[i]结尾的子数组中最大的数组和
    // 这样计算题目的结果，就需要遍历一下dp，选择Math.max(dp[i])
    // 那么dp[i]就取决于两种情况：
    //      1. 用nums[i]跟dp[i-1]对应的数组（该数组以nums[i-1]结尾，因此跟nums[i]相连）组成一个数组
    //      2. 不与前面组成数组，自己独立成一个数组
    // 应当从这两种情况当中取大值

    // 下面这里用i表示第i个数字，而又至少有一个元素，所以i从1开始
    // i=0是没有用到的，也可以用i表示索引为i的数字，这样i可以从0开始，
    // 这样dp[i]和nums[i]可以对应上，而不是像现在这样，dp[i]跟nums[i-1]对应

    public int maxSubArray(int[] nums) {

        int n = nums.length;
        // 注意尺寸+1, 因为dp表示以第i个数字结尾的，因此i应当取0到n
        int[] dp = new int[n+1];
        // 子数组至少有一个元素，因此dp[0]不可能是最终结果，而dp[1]应当是nums[0], 
        // 因为只有一个元素的话，它的最大子数组和就是他自己
        dp[1] = nums[0];

        // 从第二个数字开始，计算以当前数字为结尾的所有子数组的最大和
        for (int i = 2; i <= n; i++) {
            // 取决于情况1. 之前的数字的最大子数组和，以及
            // 情况2. 自己单独成为一个子数组，
            // 两种情况取大值
            // 注意索引，i表示第i个数字，数组中的i需要-1，而dp中不需要
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
        }

        // dp[i]表示以nums[i]结尾的最大子数组和，最终结果还需要再查一下dp中的最大值
        // 注意题目要求至少包含一个元素，所以不能取dp[0]
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }
}
// @lc code=end

