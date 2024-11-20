/*
 * @lc app=leetcode.cn id=481 lang=java
 *
 * [481] 神奇字符串
 */

// @lc code=start
class Solution {
    public int magicalString(int n) {
        // 这个字符串是 1 和 2 交替的
        // 至于每组 1 和 2 分别有多少个，取决于当前是第几组，以及第i个字符的数字
        // 固定的前三位为 122
        // 模拟生成出来

        if (n == 0) return 0; // 边界情况
        if (n <= 3) return 1; // 特殊情况：n 小于等于 3 时字符串总是 "122"

        // 初始化字符串和指针
        StringBuilder magical = new StringBuilder("122");
        int head = 2; // 指向生成字符串时的参考字符
        int countOnes = 1; // 记录 '1' 的数量，初始为 1

        while (magical.length() < n) {
            // 获取当前参考字符
            int repeat = magical.charAt(head) - '0';
            // 获取当前尾部字符（需要交替变换）
            char nextChar = magical.charAt(magical.length() - 1) == '1' ? '2' : '1';

            // 根据参考字符重复追加 nextChar
            for (int i = 0; i < repeat; i++) {
                magical.append(nextChar);
                if (nextChar == '1' && magical.length() <= n) {
                    countOnes++; // 只统计前 n 个字符的 '1'
                }
            }

            // 移动参考指针
            head++;
        }

        return countOnes;
    }
}
// @lc code=end

