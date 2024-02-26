/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length;

        int[] dp = new int[n];

        if (n == 0 || cs[0] == '0') {
            return 0;
        }

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (cs[i] > '0') {
                dp[i] = dp[i - 1];
            }
            if (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] <= '6')) {
                // 这里因为取决于i-2，当i<2时会越界，判断一下
                if (i < 2) {
                    // 此时其实只可能是i=1，也就是仅有前两个字符
                    // 那么两位数只有一种可能，这里+1
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end

