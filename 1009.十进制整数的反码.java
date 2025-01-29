/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int n) {
        // 对一个数取反,也就是 0 变 1, 1 变 0
        // 一位数字对 1 进行异或就是这种变化操作
        // 所以只要对数字的每一位都进行一次对 1 的异或即可
        // 可以构造一个长度等于原数字的全是 1 的 mask
        // 原数字对 mask 异或即可

        // 初始化 mask 为 1, 因为至少会有一位数字
        int mask = 1;

        // 找到长度等于原数字的 mask
        // 这个 mask 刚好是略大于等于 n 的
        while (mask < n) {
            // mask 往左移动,右边补 1
            mask = (mask << 1) + 1;
        }

        return mask ^ n;
    }
}
// @lc code=end

