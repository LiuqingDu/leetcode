/*
 * @lc app=leetcode.cn id=3264 lang=java
 *
 * [3264] K 次乘运算后的最终数组 I
 */

// @lc code=start
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int m = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[m]) {
                    m = j;
                }
            }
            nums[m] *= multiplier;
        }
        return nums;
    }
}
// @lc code=end

