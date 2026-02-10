/*
 * @lc app=leetcode.cn id=2864 lang=java
 *
 * [2864] 最大二进制奇数
 */

// @lc code=start
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0, zeros = 0;

        // 统计 1 和 0 的数量
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            } else {
                zeros++;
            }
        }

        StringBuilder sb = new StringBuilder();

        // 前面放 ones - 1 个 '1'
        for (int i = 0; i < ones - 1; i++) {
            sb.append('1');
        }

        // 中间放所有 '0'
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        // 最后放 1 个 '1'，保证是奇数
        sb.append('1');

        return sb.toString(); 
    }
}
// @lc code=end

