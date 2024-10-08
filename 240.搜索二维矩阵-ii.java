/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 每一行左边小右边大，每一列上面小下面大
        // 可以发现右上角的数字，是这一行最大的，同时是这一列最小的
        // 把目标数字跟右上角对比，
        // 如果目标数字大，那么这一行的数字都比目标小，这一行可以排除
        // 如果目标数字小，那么这一列的数字都比目标大，这一列可以排除

        // 从右上角开始
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            // 如果右上角小于 target，那么排除这一行
            if (matrix[i][j] < target) {
                i++;
            } else {
                // 如果右上角大于 target，那么排除这一列
                j--;
            }
        }

        return false;
    }
}
// @lc code=end

