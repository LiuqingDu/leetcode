/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        // 一位数有 9 个，两位数 90 个，三位数 900 个
        // 得先知道目标数是几位数，然后算出它是这一级别的第几个数，最后再取对应位的数字

        // base 是这一级别有多少个数字
        int level = 1, base = 9;
        // 如果超过了当前级别的数量，那么它应该是后面级别的，需要把当前级别处理掉
        // level 表示在第几级别，也表示当前级别有多少个数字
        while (n > level * base) {
            // 减去当前级别的数量，数量是当前级别（每个数字有几位）乘以数字的个数
            n -= level * base;
            level++;
            base *= 10;
            // 防止下一轮 while 的条件里乘上 base 导致溢出
            // 这里提前判断一下
            if (Integer.MAX_VALUE / base < level) {
                break;
            }
        }
        // 到这里 n 表示在当前级别下，第几位数字是目标数字

        // 表示当前级别的第一个数字
        int startNum = (int) Math.pow(10, level - 1);
        // 算出目标数字，注意这里要理解第 1 到第 level 位属于第 1 个数字
        // 因为 startNum 已经是第一个数字了，那么 offset 应该是 0
        // 也就是加号右边应该是 0，所以这里先把 n减去 1，使得算出来的 offset 正确
        int targetNum = startNum + (n - 1) / level;

        // 算出目标数字第几位，同理，第1 到 level 位应该对应下标 0
        int ind = (n - 1) % level;
        return String.valueOf(targetNum).charAt(ind) - '0';
    }
}
// @lc code=end

