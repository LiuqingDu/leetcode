/*
 * @lc app=leetcode.cn id=2022 lang=java
 *
 * [2022] 将一维数组转变成二维数组
 */

// @lc code=start
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][];
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[i * n + j];
            }
        }
        return result;
    }
}
// @lc code=end

