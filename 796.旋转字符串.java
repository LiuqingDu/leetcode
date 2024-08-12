/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        s = s + s;
        for (int i = 0; i < n; i++) {
            if (s.substring(i, i + n).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

