/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 错位比较
        // 每一行向右移动一位然后跟下一行比较，如果相同的话就符合要求
        // 错位比较的时候忽略第一行最后一个和第二行第一个
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

