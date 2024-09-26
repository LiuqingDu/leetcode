/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // https://leetcode.cn/problems/interleaving-string/solutions/335561/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch
        // 可以看做是二维棋盘，从左上角到右下角寻找一条路
        // 竖边每格代表 s1 的字符，横边每格代表 s2 的每个字符
        // 能找到一条路径走到右下角，使得经过的字符是 s3
        // 棋盘路径使用 dp
        // 记 dp[i][j] 表示 s1 前 i 个字符，s2 前 j 个字符能否拼出 s3 前 i+j 个字符
        // 每次要么往下走表示取一个s1 字符，要么往右走表示取一个 s2 字符
        // 起始点记为 0,0 = true

        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 如果 i>0 那么可以从上面走过来，
                // 要求是上面的为 true 且当前 s1 的字符匹配 s3 对应字符
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                // 同理，左边走过来
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

