/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    // 因为堆数为偶数，所以先手可以控制自己永远只拿序号为奇数的堆或者偶数的堆
    // 那么开局的时候先手可以根据计算所有奇数堆跟偶数堆哪个总数大，就让自己永远拿那些堆来确保自己赢
    // 比如1，2，3，4堆，先手如果想拿奇数堆，就先拿1，那么后手只能拿偶数2或者4，先手可以再拿3
    // 如果先手想拿偶数堆，就先拿4，给后手留下1和3，无论如何先手都还可以拿2
    // 所以先手永远赢
    // public boolean stoneGame(int[] piles) {
    //     return true;
    // }

    // 动态规划
    // dp[i][j]，定义为当游戏只有从i到j之间的堆时
    // （不计其他堆，假设游戏初始只有i到j的堆），
    // 双方取这些石子能形成的最大的差值，差值为先手玩家石子数减去后手玩家石子数
    // 容易得出dp[i][i] = piles[i]，也就是说，
    // 如果游戏一开始就只有第i堆这一堆，那么双方取完石子后最大差值就是这一堆的数量
    // 转移方程就是：当前玩家（不一定是先手玩家）取第i堆和取第j堆这两个方案的最优解。
    // 这两个方案分别是：（A）取第i堆，再减去[i+1,j]的最大差值（因为这个最大差值肯定是对手拿到的）
    // （B）取第j堆，再减去[i,j-1]的最大差值
    // 那么dp[i][j] = Max(A, B)
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // 注意dp[0][0]的情况已经在上面有了，那么至少要从dp[0][1]开始，也就是只有有前两堆石子开始算
        // 另外dp[n-1][n-1]也有了，那么最终只要算到dp[n-2][n-1]即可，也就是算到只有最后两堆石子
        // 注意下面的i<n-1和j=i+1
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        // 判断这个差值是否大于零，也就是先手玩家能否拿到更多石子
        return dp[0][n - 1] > 0;
    }
}
// @lc code=end

