/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        // 动态规划
        // dp[i][j] 表示索引 i 到 j 之间的字符串是不是回文
        // dp[i][j] 是回文的条件首先是 s[i]==s[j]
        // 其次, 要么 j-i < 2, 也就是当前字符串长度为 1 或者 2
        //      要么 dp[i+1][j-1] 也是回文

        // 动态规划的空间复杂度是 N^2
        // 用中心扩展法可以降低空间复杂度
        // 从一个字符串的最中心出发,如果中心两边外的字符相同,那么加上它们依然是回文
        // 这样一直扩展下去,就可以算出以这个中心有多少个回文串了
        // 那么对于一个字符串,有 n 个字符,每个字符都可以是中心,
        // 另外相邻的两个字符也是中心, 有 n-1 组
        char[] cs = s.toCharArray();
        int n = cs.length;

        int ans = 1;
        for (int i = 0; i < n - 1; i++)
            ans += centerSpread(cs, i, i) + centerSpread(cs, i, i + 1);

        return ans;

    }

    private int centerSpread(char[] cs, int l, int r) {
        while (0 <= l && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }
        return (r - l) / 2;
    }
}
// @lc code=end

