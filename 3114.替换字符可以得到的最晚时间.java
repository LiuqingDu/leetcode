/*
 * @lc app=leetcode.cn id=3114 lang=java
 *
 * [3114] 替换字符可以得到的最晚时间
 */

// @lc code=start
class Solution {
    public String findLatestTime(String s) {
        char[] chars = s.toCharArray();

        // 1. 处理小时的第一位 s[0]
        if (chars[0] == '?') {
            // 关键修正：如果第二位已经有数字，且大于 '1'（比如 '3'），第一位只能填 '0'
            if (chars[1] != '?' && chars[1] > '1') {
                chars[0] = '0';
            } else {
                chars[0] = '1';
            }
        }

        // 2. 处理小时的第二位 s[1]
        if (chars[1] == '?') {
            // 如果第一位是 '1'，第二位最大是 '1' (即 11)
            // 如果第一位是 '0'，第二位最大可以是 '9' (即 09)
            if (chars[0] == '1') {
                chars[1] = '1';
            } else {
                chars[1] = '9';
            }
        }

        // 3. 处理分钟的十位 s[3]
        if (chars[3] == '?') {
            chars[3] = '5';
        }

        // 4. 处理分钟的个位 s[4]
        if (chars[4] == '?') {
            chars[4] = '9';
        }

        return new String(chars);
    }
}
// @lc code=end

