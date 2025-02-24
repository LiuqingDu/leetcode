/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // 如果计算两个点之间的斜率,那么可能会涉及到分母为 0
        // 也就是如果平行于 y 轴需要特殊处理
        // 使用向量, 以 p0 为基准,分别计算它与p1,p2...的向量
        // 如果两个向量共线,则两个向量有|a,b|=0
        // 也就是二阶矩阵行列式为 0
        // 这样就转换为乘法,避免除法

        int n = coordinates.length;
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x = coordinates[1][0] - x0, y = coordinates[1][1] - y0;
        for (int i = 2; i < n; i++) {
            int xi = coordinates[i][0] - x0;
            int yi = coordinates[i][1] - y0;
            if ((x * yi - y * xi) != 0) {
                return false;
            }
        }
        return true;

    }
}
// @lc code=end

