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
        return dfs(n, k, row, column);
    }

    // 表示在边长为n的棋盘中，坐标为row和column，走k步后还在棋盘内的概率
    private double dfs(int n, int k, int row, int column) {
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


    // 动态规划
    // 这个方法比dfs要慢一些，因为dfs没有把所有格子的概率都算出来，只算了需要的那部分
    // 动态规划则是把所有格子所有可能性都算了一遍
    // 定义dp[i][j][k]表示走了k步后，落到(i, j)格子的概率
    // 可以看出来它取决于上一步的概率，当前格子周围的8个格子均有概率落在当前格子上，
    // 那么也就取决于k-1步落到这8个格子的概率之和
    // public double knightProbability(int n, int k, int row, int column) {
    //     double[][][] dp = new double[n][n][k + 1];

    //     // 因为k取决于k-1，k-1取决于k-2，所以需要从k=0算起
    //     for (int kk = 0; kk <= k; kk++) {
    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < n; j++) {
    //                 // 如果步数为0，那么概率就是1
    //                 if (kk == 0) {
    //                     dp[i][j][kk] = 1l;
    //                 } else {
    //                     double posibility = 0l;
    //                     for (int[] move: moves) {
    //                         int preI = i - move[0];
    //                         int preJ = j - move[1];
    //                         // 上一步在棋盘里的时候才加起来，否则当0看待
    //                         // 这里一定要判断，因为棋盘外的概率是0，但又不存在dp当中
    //                         // dp只保存了棋盘内的概率
    //                         if (preI >= 0 && preI < n && preJ >=0 && preJ < n) {
    //                             // 把上一步的概率加起来
    //                             posibility += dp[preI][preJ][kk - 1];
    //                         }
    //                     }
    //                     posibility /= 8.0;
    //                     dp[i][j][kk] = posibility;
    //                 }
    //             }
    //         }
    //     }

    //     return dp[row][column][k];
    // }
}
// @lc code=end

