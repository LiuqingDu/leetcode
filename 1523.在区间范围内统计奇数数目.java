/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        int res = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1) {
            res++;
        }
        return res;
    }
}
// @lc code=end

