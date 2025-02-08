/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        int i = 3;
        while (i <= n) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
            i++;
        }
        return c;
    }
}
// @lc code=end

