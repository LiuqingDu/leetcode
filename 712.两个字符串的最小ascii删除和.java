/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {
    // 类似1143题最大公共子序列，那道题是计算最大长度，这道题把最大长度改成ascii码和就行
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 注意1143题当中，初始化为0就可以，因为那道题dp表示公共子序列的最大长度
        // 一个字符串跟一个空字符串的最大子序列长度就是0，所以不需要特殊初始化
        // 但这道题，一个字符串跟空字符串的删除和应当是前者的所有字符的ascii和，
        // 因此需要初始化一下
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

