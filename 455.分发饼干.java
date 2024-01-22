/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int i = 0, j = 0;
        int m = g.length, n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }
}
// @lc code=end

