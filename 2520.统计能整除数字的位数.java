/*
 * @lc app=leetcode.cn id=2520 lang=java
 *
 * [2520] 统计能整除数字的位数
 */

// @lc code=start
class Solution {
    public int countDigits(int num) {
        int t = num;
        int res = 0;
        while (t != 0) {
            if (num % (t % 10) == 0) {
                res++;
            }
            t /= 10;
        }
        return res;
    }
}
// @lc code=end

