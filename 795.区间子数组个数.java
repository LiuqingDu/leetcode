/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 动态规划, dp[i] 表示以第 i 个数字结尾的满足要求的数组有多少个
        // 如果当前数字比 right 大,那么以当前数字结尾的任何数组都不满足要求
        // 如果当前数字比 left 小,那么当前数字不能独立形成数组,它必须依赖于以它左侧数字结尾的数组
        // 所有左侧数字结尾的数组都可以再多拼接一个当前数字来形成一个满足条件的数组, 那么此时 dp[i] = dp[i-1]
        // 如果当前数字在 [left,right] 区间, 那么在它左侧数字结尾数组和自己拼接的基础上,
        // 额外地,当前数字自己也可以形成一个满足条件的数组
        // 另外,如果它左侧有连续的小于 left 的数字,那么从这些数字开始一直连到当前数字之间也可以形成满足条件的数组
        // 这就要求另外维护一个数组来记录每个数字及它左边一共有多少个连续的小于 left 的数字
        // 那么此时 dp[i] = dp[i-1] + 1 + leftThanLeft[i-1]
        // 表示首先所有左侧数字结尾的数组都可以加上当前数字,然后加上当前数字自己的数组,最后加上左侧连续小于 left 的数字跟当前数字组合形成的数组
        
        int n = nums.length;
        // 以当前数字结尾可以形成多少个数组
        int[] dp = new int[n];
        // 表示当前数字及左侧有多少个连续的小于 left 的数字
        int[] lessThanLeft = new int[n];
        // 方便后续计算,先特殊处理一下索引 0
        dp[0] = (nums[0] >= left && nums[0] <= right) ? 1 : 0;
        lessThanLeft[0] = nums[0] < left ? 1 : 0;

        int res = dp[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > right) {
                // 如果当前数字大于 right 则无法形成当前数字结尾的数组
                dp[i] = 0;
            } else if (nums[i] < left) {
                // 如果小于 left, 则可以形成,但完全依赖于左侧数字结尾的数组
                dp[i] = dp[i - 1];
            } else {
                // 如果在区间内,则可以形成,且额外多一个当前数字的数组,以及它左侧小于 left 的数字与自己形成的数组
                dp[i] = dp[i - 1] + 1 + lessThanLeft[i - 1];
            }

            // 更新左侧连续小于 left 的数量
            lessThanLeft[i] = nums[i] < left ? lessThanLeft[i - 1] + 1 : 0;
            // 最终结果是累加的
            res += dp[i];
        }
        return res;
    }
}
// @lc code=end

