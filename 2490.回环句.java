/*
 * @lc app=leetcode.cn id=2490 lang=java
 *
 * [2490] 回环句
 */

// @lc code=start
class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            } 
        }
        return true;
    }
}
// @lc code=end

