/*
 * @lc app=leetcode.cn id=3151 lang=java
 *
 * [3151] 特殊数组 I
 */

// @lc code=start
class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;

    }
}
// @lc code=end

