/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        // 如果两个线段斜率相等,则在同一个直线上
        // 斜率涉及除法,可能会有精度的问题
        // 改用乘法
        // 如果三点共线则
        // (y2 - y1)*(x3 - x1) == (y3 - y1)*(x2 - x1)

        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        // 检查是否共线
        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1);
    }
}
// @lc code=end

