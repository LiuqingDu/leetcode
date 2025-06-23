/*
 * @lc app=leetcode.cn id=1961 lang=java
 *
 * [1961] 检查字符串是否为数组前缀
 */

// @lc code=start
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        // 依次拼接每个单词,直到超出长度
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(word);
            if (sb.length() >= s.length()) {
                break;
            }
        }
        
        return sb.toString().equals(s);
    }
}
// @lc code=end

