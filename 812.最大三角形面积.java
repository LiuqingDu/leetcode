/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
    public double largestTriangleArea(int[][] points) {
        // https://leetcode.cn/problems/largest-triangle-area/solutions/1494969/by-fuxuemingzhu-czdh/

        int N = points.length;
        double res = 0;
        for (int i = 0; i < N - 2; i ++) {
            for (int j = i + 1; j < N - 1; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];
                    res = Math.max(res, 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
                }
            }
        }
        return res;
    }
}
// @lc code=end

