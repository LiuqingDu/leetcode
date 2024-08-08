/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (!compareTwoRow(matrix[i], matrix[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean compareTwoRow(int[] row1, int[] row2) {
        int n = row1.length;
        for (int i = 0; i < n - 1; i++) {
            if (row1[i] != row2[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

