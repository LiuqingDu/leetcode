/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
class Solution {

    // 

    double[][][] memo;
    int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n][n][k + 1];
        return dp(n, k, row, column);
    }

    private double dp(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (memo[row][column][k] != 0) {
            return memo[row][column][k];
        }

        double posibility = 0l;
        for (int[] move: moves) {
            posibility += dp(n, k - 1, row + move[0], column + move[1]);
        }

        posibility /= 8.0;

        memo[row][column][k] = posibility;

        return posibility;
    }
}
// @lc code=end

