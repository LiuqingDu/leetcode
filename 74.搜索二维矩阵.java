/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] < target) {
                l = mid + 1;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else if (matrix[mid][0] == target) {
                return true;
            }
        }

        int row = l - 1;
        if (row < 0) {
            row = 0;
        }
        if (matrix[row][0] > target) {
            return false;
        }

        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2 ;
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else if (matrix[row][mid] == target) {
                return true;
            }
        }

        return matrix[row][l] == target;

    }
}
// @lc code=end

