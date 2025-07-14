/*
 * @lc app=leetcode.cn id=2016 lang=java
 *
 * [2016] 增量元素之间的最大差值
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        // 记录每个元素之前的最小值

        int n = nums.length;
        int ans = -1, premin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > premin) {
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

