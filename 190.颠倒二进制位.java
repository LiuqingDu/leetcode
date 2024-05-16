/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 因为Java使用补码表示负数，所以需要用位运算
        // JS则不需要用位运算
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // res << 1是向左移动一位，把最右边一位空出来
            // 相当于JS版的*2
            // n&1 是取出最右边一位，相当于JS版的%2
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }

        return res;
    }
}
// @lc code=end

