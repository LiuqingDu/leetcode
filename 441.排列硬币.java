/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // 二分法
        // 前n排硬币总数是（首项+末项）*项数/2
        // n(n+1)/2
        // 判断满行数跟n的关系就可以
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) / 2 <= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end

