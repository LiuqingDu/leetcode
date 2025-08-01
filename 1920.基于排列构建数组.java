/*
 * @lc app=leetcode.cn id=1920 lang=java
 *
 * [1920] 基于排列构建数组
 */

// @lc code=start
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
// @lc code=end

