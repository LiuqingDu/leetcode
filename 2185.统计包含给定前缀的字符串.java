/*
 * @lc app=leetcode.cn id=2185 lang=java
 *
 * [2185] 统计包含给定前缀的字符串
 */

// @lc code=start
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

