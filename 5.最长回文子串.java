/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    
    int max = 1, start = 0;

    boolean dp[][] = new boolean[len][len];

    for (int i = 0; i < len; i++) {
      dp[len][len] = true;
    }

    return s.substring(start, start + max);
  }
}
// @lc code=end
