/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {

        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min * num, num);
            max = Math.max(max * num, num);

            res = Math.max(res, max);
        }

        return res;
    }
}
// @lc code=end

