/*
 * @lc app=leetcode.cn id=2778 lang=java
 *
 * [2778] 特殊元素平方和
 */

// @lc code=start
class Solution {
    public int sumOfSquares(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res += nums[i - 1] * nums[i - 1];
            }
        }
        return res;
    }
}
// @lc code=end

