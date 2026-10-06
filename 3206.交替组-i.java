/*
 * @lc app=leetcode.cn id=3206 lang=java
 *
 * [3206] 交替组 I
 */

// @lc code=start
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i - 1 + n) % n] && colors[i] != colors[(i + 1) % n]) {
                res += 1;
            }
        }
        return res;

    }
}
// @lc code=end

