/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        // 双指针,分别指向较小的 a 和较大的 b
        // 如果 a^2 + b^2 = c, 则找到目标答案
        // 如果 a^2 + b^2 < c, 则把 a+1
        // 如果 a^2 + b^2 > c, 则把 b+1
        // 为什么要这样就是正确答案? 还不会错过正确答案?
        // 用表格列出所有 a^2 + b^2 的可能
        //   b  0  1  2  3  4
        // a
        // 0    0   1   4   9 (16)
        // 1    1   2   5  10  17
        // 2    4   5   8  13  20
        // 3    9  10  13 [18] 25
        // 4   16  17  20  25  32
        // 表格中间内容是所有可能的的平方和
        // 注意到表格内的数字从左往右递增
        // 从上往下递增
        // 圆括号表示当前的 a^2 + b^2
        // 方括号表示目标 c
        // 起始的圆括号必定是右上角
        // 如果当前 a^2 + b^2 < c
        // 也就是圆括号内的值比目标值小,那么目标值必定不在它左边
        // 也就是排除了当前一横行, 那么也就是要把圆括号往下移动
        // 也就是 a+1
        // 同理, 如果 a^2 + b^2 > c
        // 那么就是排除了当前圆括号下方的值, 就需要左移
        // 也就是 b-1

        long left = 0;
        long right = (long) Math.sqrt(c);
        // 注意两个值可以相等
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
// @lc code=end

