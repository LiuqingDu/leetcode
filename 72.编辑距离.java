/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    // 动态规划
    // 这道题从word1变为word2和word2变为word1是一回事，我们假定为word1变为word2
    // 定义dp[i][j]表示word1的前i个字符改造为word2的前j个字符需要多少操作
    // 我们从两个字符串的开头开始看，当两个指针i和j指向的字符相同时，不用修改，
    // 当前操作数等于它们除了当前字符外，前面剩余的字符的操作数
    //      也就是取决于dp[i-1][j-1]
    // 当指向字符不同时，有三种方案：1. 增加字符，2. 删除字符，3. 替换字符
    // 这三种方案当中修改次数较小的作为本次结果
    // 假设选择1. 那么也就是说将word1的前i个字符先改造成word2的前j-1个字符，然后在word1末尾加上word2的第j个字符，使得它们相等
    //      也就是说取决于dp[i][j-1]
    // 同理，选择2. 也就是说用word1的前i-1个字符改造成word2的前j个字符，然后删除word1第i个字符，使得它等于word2
    //      也就是取决于dp[i-1][j]
    // 同理，选择3. 就是说先用word1的前i-1个字符改造为word2的前j-1个字符，然后替换word1第i个字符使得等于word2的第j个字符
    //      也就是取决于dp[i-1][j-1]

    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        // 注意索引表示第几个字符，所以应当取值0到m或n，尺寸应当+1
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意i和j表示第几个字符，对应到字符串的索引要-1
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // 如果字符相同，则不用操作，操作数取决于前面的字符的操作数
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 如果不同，则取决于三种方案较小的一种，然后加上当前的操作数1
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    private int min (int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end

