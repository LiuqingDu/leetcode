/*
 * @lc app=leetcode.cn id=3110 lang=java
 *
 * [3110] 字符串的分数
 */

// @lc code=start
class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        
        // 注意：循环条件是 s.length() - 1，因为最后一个字符没有“右边邻居”了
        for (int i = 0; i < s.length() - 1; i++) {
            // s.charAt(i) 是当前字符，s.charAt(i + 1) 是右边紧挨着的字符
            // Math.abs() 用来计算绝对值
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        
        return score;
    }
}
// @lc code=end

