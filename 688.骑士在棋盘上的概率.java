/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
class Solution {

    // 带备忘录的dfs，这个解法本质是dfs，不断尝试每一种选择，计算每种选择的可能性
    // 用备忘录避免重复计算
    double[][][] memo;
    int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        // 记录在坐标(row, column)的位置走k步，在棋盘内的概率，因为k可以是0，所以初始化容量+1，为[0, k]区间
        memo = new double[n][n][k + 1];
        return dp(n, k, row, column);
    }

    // 表示在边长为n的棋盘中，坐标为row和column，走k步后还在棋盘内的概率
    private double dp(int n, int k, int row, int column) {
        // 如果现在已经超出棋盘范围了，直接停止，不再继续走，并且返回概率0
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }

        // 如果在棋盘内，且没有剩余步数了，那么概率就是1
        if (k == 0) {
            return 1;
        }

        // 如果备忘录有，就直接返回
        if (memo[row][column][k] != 0) {
            return memo[row][column][k];
        }

        // 记录所有可能性
        // 遍历8种走法，把每种走法的概率都加起来
        double posibility = 0l;
        for (int[] move: moves) {
            posibility += dp(n, k - 1, row + move[0], column + move[1]);
        }
        // 加完以后要除以8，因为每种走法被选择的概率为1/8
        posibility /= 8.0;

        // 备忘录
        memo[row][column][k] = posibility;

        return posibility;
    }
}
// @lc code=end

