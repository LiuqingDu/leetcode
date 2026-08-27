/*
 * @lc app=leetcode.cn id=3274 lang=java
 *
 * [3274] 检查棋盘方格颜色是否相同
 */

// @lc code=start
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        
        return (coordinate1.charAt(0) - coordinate2.charAt(0) + coordinate1.charAt(1) - coordinate2.charAt(1)) % 2 == 0;

    }
}
// @lc code=end

