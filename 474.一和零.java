/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp
        // 每一个字符串都需要决定用还是不用
        // 且如果用当前字符串，那么可以组成的子集的长度
        // 等于从 m 和 n 中分别减去当前字符串的 0 和 1 的个数
        // 的情况下，最长子集长度再+1
        // dp[i][j][k] 表示输入字符串在子区间 [0, i] 能够使用 j 个 0 和 k 个 1 的字符串的最大数量。
        // 如果不选择当前考虑的字符串，至少是下面这个数值
        // dp[i−1][j][k]
        // 如果选择当前考虑的字符串，那么是下面这个数
        // dp[i−1][j−当前字符串使用0的个数][k−当前字符串使用1的个数]+1

        // 为了避免分类讨论，通常多设置一行。这里可以认为，第 0 个字符串是空串。第 0 行默认初始化为 0。
        // 输出：输出是最后一个状态，即：dp[len][m][n]。

        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            // 注意：有一位偏移
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先把上一行抄下来
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];
                    // 这里意思是，如果当前允许的题目里的 m 和 n 可以容得下当前字符串，那么才考虑把当前字符串放进去
                    // 比如如果限定最多 2 个 0 以及 1 个 1，那么 0011 就不能放进去
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}
// @lc code=end

