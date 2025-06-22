/*
 * @lc app=leetcode.cn id=1957 lang=java
 *
 * [1957] 删除字符使字符串变好
 */

// @lc code=start
class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // 当前字符重复的次数

        for (int i = 0; i < s.length(); i++) {
            // 如果不是第一个字符，且当前字符和上一个字符相同
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // 新字符，重置计数
            }

            // 只有当连续字符少于 3 个时，才加到结果里
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
// @lc code=end

