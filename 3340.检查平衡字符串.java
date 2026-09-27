/*
 * @lc app=leetcode.cn id=3340 lang=java
 *
 * [3340] 检查平衡字符串
 */

// @lc code=start
class Solution {
    public boolean isBalanced(String num) {
        
        int diff = 0, sign = 1;
        for (int i = 0; i < num.length(); ++i) {
            int d = num.charAt(i) - '0';
            diff += d * sign;
            sign = -sign;
        }
        return diff == 0;

    }
}
// @lc code=end

