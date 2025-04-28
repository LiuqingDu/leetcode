/*
 * @lc app=leetcode.cn id=1637 lang=java
 *
 * [1637] 两点之间不包含任何点的最宽垂直区域
 */

// @lc code=start
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // 题目描述很绕,其实就是 x 坐标当中,相邻x 坐标的最大间距

        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int mx = 0;
        for (int i = 1; i < points.length; i++) {
            mx = Math.max(points[i][0] - points[i - 1][0], mx);
        }
        return mx;
    }
}
// @lc code=end

