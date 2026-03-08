/*
 * @lc app=leetcode.cn id=3000 lang=java
 *
 * [3000] 对角线最长的矩形的面积
 */

// @lc code=start
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int len = 0;
        int area = 0;

        for (int i = 0; i < dimensions.length; i++) {
            int x = dimensions[i][0];
            int y = dimensions[i][1];

            int l = x * x + y * y;
            int a = x * y;

            if (l > len || (l == len && a > area)) {
                len = l;
                area = a;
            }
        }

        return area;
    }
}
// @lc code=end

