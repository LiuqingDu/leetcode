/*
 * @lc app=leetcode.cn id=1929 lang=java
 *
 * [1929] 数组串联
 */

// @lc code=start
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];        // 第一遍复制
            ans[i + n] = nums[i];    // 第二遍复制
        }
        
        return ans;
    }
}
// @lc code=end

