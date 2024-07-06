/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        // 按顺序依次从原数组取出并放入新数组
        int[][] res = new int[r][c];
        int total = m * n;
        for (int i = 0; i < total; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }

        return res;
    }
}
// @lc code=end

