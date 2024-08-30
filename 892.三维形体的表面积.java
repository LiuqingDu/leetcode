/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        // 每个坐标上是一个立方体柱子
        // 每个柱子提供了上下两个面以及四个侧面，总面数为 2+4*层数
        // 从坐标（0,0）开始依次放置柱子，每一个新柱子要跟它（鸟瞰）左侧以及上侧的柱子有贴合
        // 贴合的面要减去，贴合面的高度就是它与左侧、上侧的柱子中较小的高度

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 取出当前柱子的高度
                int stack = grid[i][j];
                // 新柱子单独提供的表面
                res += stack * 4 + 2;

                // 从第二排开始，它上面就有可能有柱子，需要减去贴合面
                if (i > 0) {
                    // 贴合面高度取两者小值，减去的贴合面要算双份的
                    res -= Math.min(stack, grid[i - 1][j]) * 2;
                }

                if (j > 0) {
                    res -= Math.min(stack, grid[i][j - 1]) * 2;
                }
            }
        }
        return res;
    }
}
// @lc code=end

