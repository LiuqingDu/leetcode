/*
 * @lc app=leetcode.cn id=2255 lang=java
 *
 * [2255] 统计是给定字符串前缀的字符串数目
 */

// @lc code=start
class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

