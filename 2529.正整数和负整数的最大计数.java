/*
 * @lc app=leetcode.cn id=2529 lang=java
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lc code=start
class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}
// @lc code=end

