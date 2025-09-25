/*
 * @lc app=leetcode.cn id=926 lang=java
 *
 * [926] 将字符串翻转到单调递增
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        // 明显dp
        // dp[i][0]表示第i个字符是0,形成单调递增的最小翻转次数
        // dp[i][1]表示第i个字符是1,形成单调递增的最小翻转次数
        // 记fn(i,0)表示把第i个字符翻转为0的次数,同理fn(i,1)
        // 那么dp[i][0] = dp[i-1][0] + fn(i,0)
        // dp[i][1] = dp[i-1][1] + fn(i,1)
        // 但是dp[i][1]还可以由dp[i-1][0]转移过来,即前面全是0,第i个字符是1
        // 所以dp[i][1] = min(dp[i-1][0],dp[i-1][1]) + fn(i,1)
        // 初始化dp[n+1], 其中第一个位置是空的,用来启动
        // 从dp[1]开始,表示第一个字符,也就是s[0]
        int n = s.length();
        int[][] dp = new int[n+1][2];
        for(int i=1;i<=n;i++){
            // 注意这里i是从1开始的,所以要用s.charAt(i-1)
            char c = s.charAt(i-1);
            dp[i][0] = dp[i-1][0] + fn(c,'0');
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + fn(c,'1');
        }
        return Math.min(dp[n][0],dp[n][1]);
    }
    
    private int fn(char c, int target){
        return c == target ? 0 : 1;
    }
}
// @lc code=end

