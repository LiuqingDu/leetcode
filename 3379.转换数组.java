/*
 * @lc app=leetcode.cn id=3379 lang=java
 *
 * [3379] 转换数组
 */

// @lc code=start
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[((i + nums[i]) % n + n) % n];
        }
        return res;
    }
}
// @lc code=end

