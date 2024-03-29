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
        // 这里i从后面往前倒着遍历，j是从i+1开始往后正着走
        // 倒着往前的原因是：这里动态计算每一个值是取决于更短的字符串的值，
        // 那么就需要从最短的长度开始往最长的长度算，长度为1的已经初始化好了，
        // 那么就要从长度为2开始算，然后再算长度为三。
        // 这样有两种方法，一种是让i从倒数第二位开始遍历j，依次往前移动i，这样每轮的长度就是递增的
        // 或者让j从第二位开始往后，每轮遍历i。这里选择i倒着来
        for (int i = n - 2; i >= 0; i--) {
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

