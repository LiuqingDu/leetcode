/*
 * @lc app=leetcode.cn id=2011 lang=java
 *
 * [2011] 执行操作后的变量值
 */

// @lc code=start
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                x++;
            } else if (operation.charAt(1) == '-') {
                x--;
            }
        }
        return x;
    }
}
// @lc code=end

