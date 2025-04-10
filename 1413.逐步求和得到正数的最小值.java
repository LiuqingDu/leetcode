/*
 * @lc app=leetcode.cn id=1413 lang=java
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int sum = nums[0];
        int min = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        // 注意要求为正数,最少为 1
        return Math.max(1 - min, 1);
    }
}
// @lc code=end

