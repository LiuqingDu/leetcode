/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        // 先从左边过一遍，再从右边过一遍
        // j 记录最近一次遇到的字符 c 的位置
        // i 记录当前遍历的位置
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, n + 1);
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }

            if (j != -1) {
                res[i] = i - j;
            }
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                res[i] = Math.min(res[i], j - i);
            }
        }
        return res;
    }
}
// @lc code=end

