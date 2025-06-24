/*
 * @lc app=leetcode.cn id=1967 lang=java
 *
 * [1967] 作为子字符串出现在单词中的字符串数目
 */

// @lc code=start
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // 统计出现的子字符串数量
        int count = 0;
        for (String pattern : patterns) {
            // 如果当前模式字符串是单词的子字符串，则计数加一
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

