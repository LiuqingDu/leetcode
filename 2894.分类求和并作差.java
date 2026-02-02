/*
 * @lc app=leetcode.cn id=2894 lang=java
 *
 * [2894] 分类求和并作差
 */

// @lc code=start
class Solution {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
}
// @lc code=end

