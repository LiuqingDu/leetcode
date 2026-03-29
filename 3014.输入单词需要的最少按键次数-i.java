/*
 * @lc app=leetcode.cn id=3014 lang=java
 *
 * [3014] 输入单词需要的最少按键次数 I
 */

// @lc code=start
class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += i / 8 + 1;
        }

        return res;
    }
}
// @lc code=end

