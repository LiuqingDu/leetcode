/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // 完整的数组应该是长度为n+1的，值从0到n的数列
        // 给定的数组比上面的数组少一个数，求和相减即可算出缺的数字
        int sum = 0;
        int total = 0;
        int n = nums.length;
        total = (0 + n) * (n + 1) / 2;
        for (int i: nums) {
            sum+=i;
        }
        return total - sum;
    }
}
// @lc code=end

