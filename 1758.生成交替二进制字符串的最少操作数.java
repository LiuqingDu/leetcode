/*
 * @lc app=leetcode.cn id=1758 lang=java
 *
 * [1758] 生成交替二进制字符串的最少操作数
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        // 要么变成 0 开头的交替, 要么变成 1 开头的交替
        // 变成这两种情况的操作数之和肯定等于 s.length
        // 计算其中一种方案的操作数,然后可以算出另一种,比较小值即可

        int cnt = 0;
        // 计算 0 开头的方案的操作数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 第 i 位应当是 i%2, 否则操作数+1
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
// @lc code=end

