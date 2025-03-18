/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        // 看到题目文能否 O(n+m) 做出来, 就可以想到要利用上两个方向递减的规律
        // 若一个格子的数字是 x, 则它的上边,左边,左上都不小于这个 x
        // 当然我们也可以理解为
        // 从最后一行开始, 找到第一个负数后, 那么上一行的负数肯定在这个负数同列或者右边
        // 如此每一行的第一个负数都至少跟下一行同列或者在下一行的右边
        // 这样一行一行找也是 O(n+m)

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        // 记录当前第几列,在循环外记录这个值,保证进入到上一行的时候可以从当前列开始继续找
        // 当前列左边不会再有负数了
        int col = 0;

        // 计算每一行, 注意倒着从下往上找,因为上一行的负数只会出现在同位置或者右边
        for (int row = m - 1; row >= 0; row--) {
            // 找到当前行的第一个负数
            while (col < n && grid[row][col] >= 0) {
                col++;
            }
            // 累加当前行的负数的个数
            res += (n - col);
        }

        return res;

    }
}
// @lc code=end

