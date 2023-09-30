/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    // 要求步数最小，也就是剩下的部分要最多，剩下的就是相同的，那么就是要求相同的最多
    // 这道题就变成了找长度最长的相同部分，也就是1143题找最大公共子序列
    // 然后分别把两个字符串删为公共子序列就可以了

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 计算最长公共子序列的长度
        int l = longestCommonSubsequence(word1, word2);

        return (m - l) + (n - l);
    }

    // 具体注释参考1143题，是完全相同的方法
    private int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

