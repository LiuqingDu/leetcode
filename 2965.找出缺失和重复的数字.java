/*
 * @lc app=leetcode.cn id=2965 lang=java
 *
 * [2965] 找出缺失和重复的数字
 */

// @lc code=start
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j] - 1]++;
            }
        }

        int[] res = new int[2];
        for (int i = 0; i < n * n; i++) {
            if (count[i] == 0) {
                res[1] = i + 1;
            }
            else if (count[i] == 2) {
                res[0] = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end

