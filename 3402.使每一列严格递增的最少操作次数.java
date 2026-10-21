/*
 * @lc app=leetcode.cn id=3402 lang=java
 *
 * [3402] 使每一列严格递增的最少操作次数
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[][] grid) {
        int res = 0;
        int col = grid[0].length;
        int row = grid.length;
        for (int i = 0; i < col; i++) {
            int pre = grid[0][i];
            for (int j = 1; j < row; j++) {
                res += Math.max(0, (pre + 1) - grid[j][i]);
                pre = Math.max(pre + 1, grid[j][i]);
            }
        }
        return res;
    }
}
// @lc code=end

