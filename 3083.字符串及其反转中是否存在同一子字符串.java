/*
 * @lc app=leetcode.cn id=3083 lang=java
 *
 * [3083] 字符串及其反转中是否存在同一子字符串
 */

// @lc code=start
class Solution {
    public boolean isSubstringPresent(String s) {
        // [原字符串翻转后]是否包含目标子串
        // 其实相当于原字符串是否包含[翻转后的目标子串]
        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            String rev = "" + sub.charAt(1) + sub.charAt(0);

            if (s.contains(rev)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

