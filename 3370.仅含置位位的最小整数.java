/*
 * @lc app=leetcode.cn id=3370 lang=java
 *
 * [3370] 仅含置位位的最小整数
 */

// @lc code=start
class Solution {
    public int smallestNumber(int n) {
        
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;

    }
}
// @lc code=end

