/*
 * @lc app=leetcode.cn id=1401 lang=java
 *
 * [1401] 圆和矩形是否有重叠
 */

// @lc code=start
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 求出矩形内部距离圆心最近的点的坐标 (nearestX, nearestY)
        int nearestX = Math.max(x1, Math.min(xCenter, x2));
        int nearestY = Math.max(y1, Math.min(yCenter, y2));

        int dx = xCenter - nearestX;
        int dy = yCenter - nearestY;

        return dx * dx + dy * dy <= radius * radius;
    }
}
// @lc code=end

