/*
 * @lc app=leetcode.cn id=1844 lang=java
 *
 * [1844] 将所有数字用字符替换
 */

// @lc code=start
class Solution {
    public String replaceDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 2) {
            sb.append(s.charAt(i));
            if (i + 1 < n) {
                int digit = s.charAt(i + 1) - '0';
                sb.append((char)(s.charAt(i) + digit));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

