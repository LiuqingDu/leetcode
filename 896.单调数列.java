/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        int diff = 0;
        for (int i = 1; i < n; i++) {
            if (diff == 0) {
                diff = nums[i] - nums[i - 1];
                continue;
            }
            if (diff * (nums[i] - nums[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

