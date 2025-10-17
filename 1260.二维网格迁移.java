/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        // 1. 将二维数组看作长度为 m * n 的一维数组（按行展开）。
        // 2. 元素 grid[i][j] 在一维中的索引为 index = i * n + j。
        // 3. 向右平移 k 次后，新位置为 newIndex = (index + k) % (m * n)。
        // 4. 再把 newIndex 转回二维坐标：(newIndex / n, newIndex % n)。
        // 5. 用一个新的二维列表 ret 存储结果。
        
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();

        // 初始化 ret 为 m×n 的 0 矩阵
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }

        // 将每个元素移动到新位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ret.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }

        return ret;
    }
}
// @lc code=end

