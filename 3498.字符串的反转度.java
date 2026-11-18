/*
 * @lc app=leetcode.cn id=3498 lang=java
 *
 * [3498] 字符串的反转度
 */

// @lc code=start
class Solution {
    public int reverseDegree(String s) {
        
        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            ans += (26 - (s.charAt(i - 1) - 'a')) * i;
        }
        return ans;

    }
}
// @lc code=end

