/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int len = sb.length();
            if (len > 0 && Math.abs(sb.charAt(len - 1) - curr) == 32) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

