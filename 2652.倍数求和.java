/*
 * @lc app=leetcode.cn id=2652 lang=java
 *
 * [2652] 倍数求和
 */

// @lc code=start
class Solution {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
// @lc code=end

