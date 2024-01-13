/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String s) {

        int rows = 1;
        int wid = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 97;
            int w = widths[c];
            if (wid + w > 100) {
                rows++;
                wid = 0;
            }
            wid += w;
        }

        return new int[]{rows, wid};
    }
}
// @lc code=end

