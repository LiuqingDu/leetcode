/*
 * @lc app=leetcode.cn id=1572 lang=java
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            res += mat[n - 1 - i][i];
        }
        if (n % 2 == 1) {
            res -= mat[n / 2][n / 2];
        }
        return res;
    }
}
// @lc code=end

