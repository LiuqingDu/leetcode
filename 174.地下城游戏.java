/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    // 此题目的是从(0, 0)走到(m-1, n-1)，且沿途生命值最少为1
    // 如果定义dp[i, j]表示走到(i, j)这个点需要多少生命值，
    // 那么就不好算了，因为每一个点需要多少生命值，取决于dp[i-1][j]和dp[i][j-1]这两个点，
    // 也就是取决于左边和上边两个点，现在dp记录的是：到达左边和上边两个点所需的最小生命值，
    // 我们无法根据这个dp值来求出当前点所需最小生命值，
    // 因为求当前所需最小值，取决于进入当前点之前，左边和上边当时剩余的生命值
    // 比如上边的点最终剩余3点dp[i-1][j]=3，当前点是-2，那么就可以走完，最小生命值不变，
    // 但如果当前点是-3，那么最小生命值就需要+1，
    // 由此可以看出，每次计算dp的时候，不仅需要左边和上边两个点的dp，还需要这两个点的最终状态，
    // 单独只保存dp是不够的。

    // 反过来定义dp[i, j]表示从(i, j)这个点到终点需要的最少生命值，这样就可以算出来了，
    // 从(i, j)到终点需要的最少的生命值，取决于dp[i+1][j]和dp[i][j+1],
    // 也就是取决于右边和下边两个dp。
    // 假设右边dp是3，当前点是1，那么当前的dp就是2，也就是说带着2点生命值进入当前点，
    // 生命值变为3, 刚好足够右边的点，
    // 假设右边dp是3，当前点是-2，那么当前的dp就是5，也就是带着5点进来，还剩余3点，
    // 刚好够右边的点
    // 这样只需要当前点的值和两个dp值即可

    // 备忘录，避免重复计算
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // 动态规划方法一，从右下角往左上角计算，不需要备忘录

        int[][] dp = new int[m][n];
        
        // base case，右下角终点
        if (dungeon[m - 1][n - 1] >= 0) {
            dp[m - 1][n - 1] = 1;
        } else {
            dp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >=0; j--) {
                // 跳过终点，已经计算过了
                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                // 找到每个点的下边和右边的最小生命值
                int bottom;
                int right;

                // 处理一下边界的情况
                if (i == m - 1) {
                    bottom = Integer.MAX_VALUE;
                } else {
                    bottom = dp[i + 1][j];
                }
                if (j == n - 1) {
                    right = Integer.MAX_VALUE;
                } else {
                    right = dp[i][j + 1];
                }

                // 取下边和右边的最小值
                int min = Math.min(bottom, right);
                // 进入当前格子之前的生命值+当前格子的值=刚才算出来的最小值
                // 当前所需最小值=算出来的下一步最小值-当前格子值
                int cur = min - dungeon[i][j];

                // 生命值最小为1
                if (cur <= 0) {
                    cur = 1;
                }

                // 记录下来
                dp[i][j] = cur;
            }
        }

        return dp[0][0];

        // 动态规划方法二，从左上角往右下角算，需要备忘录
        // memo = new int[m][n];
        // for (int[] row: memo) {
        //     // 填入一个特殊值，表示还没有计算过
        //     Arrays.fill(row, -1);
        // }

        // return dp(dungeon, 0, 0);

    }

    // 方法二的
    // 从(i, j)到右下角终点，最少需要多少生命值
    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // base case
        // 如果是终点，则可以直接得出结果
        if (i == m - 1 && j == n - 1) {
            // 如果终点格子的值是0或者正数，那么从终点出发到终点，不需要额外的生命值，1点就够了
            // 因为1点是最小值，不能是0或者负数
            if (grid[i][j] >=0) {
                return 1;
            } else {
                // 如果终点是负数，那么最小生命值要比绝对值还大1，因为需要在扣除后还至少剩1
                return -grid[i][j] + 1;
            }
        }

        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 当前dp取决于下边和右边的dp的小值，然后再减去当前格子的值
        int res = Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) - grid[i][j];

        // 生命值最少为1
        if (res <= 0) {
            res = 1;
        }

        memo[i][j] = res;

        return res;

    }
}
// @lc code=end

