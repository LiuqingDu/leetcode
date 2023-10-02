/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
class Solution {
    // 动态规划
    // 要增加字符拼成回文串，动态规划肯定是从短字符串推算到长字符串
    // 如果短字符串的方案已经算出来，那么在它基础上多一个字符的长字符串的情况就可以继续推算出来
    // 定义dp[i][j]表示索引[i, j]之间的字符串变为回文串的最少次数
    // 对于i和j，根据它的字符串长度有以下几种情况
    // 1. 长度为1，i==j，不需要修改dp=0
    // 2. 长度为2，
    //      1) 两个字符相同，则dp=0
    //      2) 不同，dp=1
    // 3. 长度为3或更多
    //      1) 两个字符相同，则dp[i][j]=dp[i+1][j-1]
    //      2) 两个字符不同，则dp[i][j]=max(dp[i][j-1], dp[i+1][j])+1
    //         也就是取决于在前面加字符或者后面加字符使得最外层的字符相同，然后看里面的字符串的回文次数

    public int minInsertions(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        // 长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // 长度为2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = 0;
            } else {
                dp[i][i+1] = 1;
            }
        }
        
        // 注意这里的计算顺序，因为长度为x的字符串取决于长度为x-1的字符串，
        // 所以需要先把所有长度为x-1的字符串的dp都算出来
        // 也就是说要先把长度为3的算出来，再算长度为4的，以此类推
        // 所以外圈循环的值是长度

        // 计算长度为3或更多，也就是j-i至少为2，字符串变为回文串的最少次数
        for (int dif = 2; dif < n; dif++) {
            for (int i = 0; i + dif < n; i++) {
                int j = i + dif;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end

