/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int count = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                count++;
                res = Math.max(res, count);
            } else if (c == ')') {
                count--;
            }
        }
        return res;
    }
}
// @lc code=end

