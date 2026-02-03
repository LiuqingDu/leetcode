/*
 * @lc app=leetcode.cn id=2923 lang=java
 *
 * [2923] 找到冠军 I
 */

// @lc code=start
class Solution {
    public int findChampion(int[][] grid) {
        // 计算每一个队分别比多少个队强,如果有一个队比n-1个队强,则它是冠军
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }

            if (sum == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

