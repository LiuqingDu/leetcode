/*
 * @lc app=leetcode.cn id=1529 lang=java
 *
 * [1529] 最少的后缀翻转次数
 */

// @lc code=start
class Solution {
    public int minFlips(String target) {
        
        int flips = 0;
        char prev = '0';
        int n = target.length();
        for (int i = 0; i < n; i++) {
            char curr = target.charAt(i);
            if (curr != prev) {
                flips++;
                prev = curr;
            }
        }
        return flips;

    }
}
// @lc code=end

