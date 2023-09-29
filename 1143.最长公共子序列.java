/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    // 肯定是动态规划
    // 如果字符串很短，就很好比较，那么动态规划也可以从短的开始，
    // 对于两个字符串s1和s2，如果它们最后一位相同，那么最长子序列的长度就等于
    // 它们去掉最后一位后的最长子序列长度再+1，加的1就是最后一位相同的字符
    // 如果不同，那么最长子序列长度取决于【s1去掉最后一个字符跟s2】和【s2去掉最后一个字符跟s1】
    // 这两种可能性当中子序列长度更大的那个
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length(), n = text2.length();
        // dp[i][j]表示s1前i个字符跟s2前j个字符的最长子序列长度
        // 那么可以确定dp[i][0]=0，dp[0][j]=0
        // 注意i和j表示前几个字符，从0开始，所以初始化size+1
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意i和j表示第几个字符，对应的索引要-1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果相等，那么长度就是在没有i和j的情况的最大长度再+1
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

