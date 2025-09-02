/*
 * @lc app=leetcode.cn id=848 lang=java
 *
 * [848] 字母移位
 */

// @lc code=start
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] result = new char[n];
        long totalShift = 0;

        // 从后往前计算每个字符需要移位多少
        for (int i = n - 1; i >= 0; i--) {
            totalShift += shifts[i];
            // 移位
            result[i] = (char) ((s.charAt(i) - 'a' + totalShift) % 26 + 'a');
        }

        return new String(result);
    }
}
// @lc code=end

