/*
 * @lc app=leetcode.cn id=2427 lang=java
 *
 * [2427] 公因子的数目
 */

// @lc code=start
class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int x = 1; x <= Math.min(a, b); ++x) {
            if (a % x == 0 && b % x == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end

