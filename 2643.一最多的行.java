/*
 * @lc app=leetcode.cn id=2643 lang=java
 *
 * [2643] 一最多的行
 */

// @lc code=start
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int count = 0;
        int ind = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                c += mat[i][j];
            }
            if (c > count) {
                count = c;
                ind = i;
            }
        }
        return new int[]{ind, count};
    }
}
// @lc code=end

