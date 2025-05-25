/*
 * @lc app=leetcode.cn id=1812 lang=java
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
class Solution {
    public boolean squareIsWhite(String coordinates) {
        // 坐标之和为偶数则是黑色, 奇数则是白色
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;
    }
}
// @lc code=end

