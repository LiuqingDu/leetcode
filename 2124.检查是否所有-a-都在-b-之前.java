/*
 * @lc app=leetcode.cn id=2124 lang=java
 *
 * [2124] 检查是否所有 A 都在 B 之前
 */

// @lc code=start
class Solution {
    public boolean checkString(String s) {
        boolean bSeen = false;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bSeen = true;
            } else if (c == 'a' && bSeen) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

