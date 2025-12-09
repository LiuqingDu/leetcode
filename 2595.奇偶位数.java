/*
 * @lc app=leetcode.cn id=2595 lang=java
 *
 * [2595] 奇偶位数
 */

// @lc code=start
class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }
}
// @lc code=end

