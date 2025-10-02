/*
 * @lc app=leetcode.cn id=885 lang=java
 *
 * [885] 螺旋矩阵 III
 */

// @lc code=start
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // 定义方向数组，表示右、下、左、上的移动方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 初始化结果数组
        int[][] result = new int[rows * cols][2];
        // 记录当前的位置
        int r = rStart, c = cStart;
        // 记录当前的方向索引
        int dirIndex = 0;
        // 记录当前的步数
        int step = 1;
        // 记录结果数组的索引
        int index = 0;
        // 记录已经访问的格子数
        int visited = 0;
        // 总格子数
        int total = rows * cols;
        // 将起始位置加入结果数组
        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            result[index++] = new int[]{r, c};
            visited++;
        }
        // 循环直到访问所有格子
        while (visited < total) {
            // 每两次改变方向后，步数增加1
            for (int i = 0; i < 2; i++) {
                // 按当前方向移动step步
                for (int j = 0; j < step; j++) {
                    r += directions[dirIndex][0];
                    c += directions[dirIndex][1];
                    // 如果当前位置在矩阵范围内，加入结果数组
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                        visited++;
                        if (visited == total) {
                            return result;
                        }
                    }
                }
                // 改变方向
                dirIndex = (dirIndex + 1) % 4;
            }
            // 每两次改变方向后，步数增加1
            step++;
        }
        return result;
    }
}
// @lc code=end

