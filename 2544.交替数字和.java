/*
 * @lc app=leetcode.cn id=2544 lang=java
 *
 * [2544] 交替数字和
 */

// @lc code=start
class Solution {
    public int alternateDigitSum(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        return -sign * res;
    }
}
// @lc code=end

