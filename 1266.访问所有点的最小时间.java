/*
 * @lc app=leetcode.cn id=1266 lang=java
 *
 * [1266] 访问所有点的最小时间
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // 很明显, 两点之间移动的最大时间应该是max(横坐标差, 纵坐标差)

        int totalTime = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            totalTime += Math.max(dx, dy);
        }
        return totalTime;
    }
}
// @lc code=end

