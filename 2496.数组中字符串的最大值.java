/*
 * @lc app=leetcode.cn id=2496 lang=java
 *
 * [2496] 数组中字符串的最大值
 */

// @lc code=start
class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String s : strs) {
            boolean isDigits = true;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                isDigits &= Character.isDigit(s.charAt(i));
            }
            res = Math.max(res, isDigits ? Integer.parseInt(s) : n);
        }
        return res;
    }
}
// @lc code=end

