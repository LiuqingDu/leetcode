/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        // 平方根不超过x的一半
        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            // 如果找到的数mid它的平方小于等于目标
            // 比mid大1的数的平方又刚好大于目标
            // 说明这个mid刚好就是结果
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = mid + 1;
            }
        }

        return (int) left;
    }
}
// @lc code=end

