/*
 * @lc app=leetcode.cn id=1913 lang=java
 *
 * [1913] 两个数对之间的最大乘积差
 */

// @lc code=start
class Solution {
    public int maxProductDifference(int[] nums) {
        // nums 均为正数, 那么最大乘积应该是最大的两个数的乘积
        // 最小乘积是最小两个数的积
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // 更新最大两个数
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // 更新最小两个数
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }
}
// @lc code=end

