/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        // 基于lc231题，那道题是判断2的幂
        // 这里可以判断n的平方根是不是2的幂
        // 可以用Math.sqrt()也可以自己实现一个
        // 注意这里求平方根算出来的是floor的值，所以需要再平方一下判断是不是真的是整数幂
        if (n <= 0) {
            return false;
        }
        int x = sq(n);
        return x * x == n && (n&(n - 1)) == 0;
    }

    private int sq(int n) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (mid * mid >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }
}
// @lc code=end

