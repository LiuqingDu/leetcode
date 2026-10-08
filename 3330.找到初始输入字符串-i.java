/*
 * @lc app=leetcode.cn id=3330 lang=java
 *
 * [3330] 找到初始输入字符串 I
 */

// @lc code=start
class Solution {
    public int possibleStringCount(String word) {
        
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++ans;
            }
        }
        return ans;

    }
}
// @lc code=end

