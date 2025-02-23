/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            count += c == 'R' ? 1 : -1;
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

