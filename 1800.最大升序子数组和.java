/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        // dp
        // 记 dp[i] 为以 nums[i] 结尾的最大元素和
        // 发现可以滚动记录而不需要维护整个 dp 数组
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int cursum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                cursum += nums[l++];
            }
            res = Math.max(res, cursum);
        }
        return res;
    }
}
// @lc code=end

