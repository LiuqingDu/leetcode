/*
 * @lc app=leetcode.cn id=2278 lang=java
 *
 * [2278] 字母在字符串中的百分比
 */

// @lc code=start
class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return (int) ((count / (double) s.length()) * 100);
    }
}
// @lc code=end

