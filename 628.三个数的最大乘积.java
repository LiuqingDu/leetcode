/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        // !. 均为正数：最大三个数乘积
        // 2. 均为负数：最大三个数乘积（最接近0的三个负数）
        // 3. 有正有负：
        //      1. 一个负数：最大三个数乘积（即使只有三个数，导致这个负数成为最大三个数之一，也不影响）
        //      2. 两个或更多个负数：max(最小的两个负数与最大的一个正数乘积，最大的三个数乘积)
        // 综合一下，最终就是比较 min1*min2*max1 和 max1*max2*max3

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int n: nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);

    }
}
// @lc code=end

