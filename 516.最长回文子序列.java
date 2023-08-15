/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    // 动态规划
    // 定义dp[i][j]表示索引为[i, j]的字符串里面最长的回文子序列的长度
    // 可知dp[i][i]肯定是1
    // 当第i个字符和第j个字符相同时，那么dp[i][j]就等于在i和j之间
    // （不含ij）的字符串的最长回文子序列长度再加上2，因为相当于两头的字符相同，那么至少它俩是个回文串
    // 当它俩不同时，就需要比较[i, j-1]和[i+1,j]这两个字符串的最大值，其最大值就是[i,j]的最大值
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 长度为1的必定是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 遍历计算回文长度
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果两头的字符相同，则回文长度+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 否则取决于仅仅加一个字符的长度
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 整个字符串最长回文子串长度
        return dp[0][n - 1];
    }
}
// @lc code=end

